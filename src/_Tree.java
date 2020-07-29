import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _Tree {

	/*
	 * 95 ��ͬ�Ķ���������
	 * */
    public List<TreeNode> generateTrees(int n) {
    	
    	if(n == 0) {
    		return new ArrayList<>();
    	}
    	
    	return help(1, n);
    }
    public List<TreeNode> help(int start, int end){
    	List<TreeNode> allTree = new ArrayList<>();
    	
    	// ���nullֵ
    	if(start > end) {
    		allTree.add(null);
    		return allTree;
    	}
    	
    	for(int i = start; i <= end; i++) {
    		// ��iΪ���ڵ����������
    		List<TreeNode> left = help(start, i-1);
    		List<TreeNode> right = help(i+1, end);
    		
    		// ���������ѿ�����
    		for(TreeNode lnode : left) {
    			for(TreeNode rnode : right) {
    				TreeNode node = new TreeNode(i);
    				node.left = lnode;
    				node.right = rnode;
    				allTree.add(node);
    			}
    		}
    	}
    	
    	return allTree;
    }
    /*
	 * 96 ��ͬ�Ķ�������������
	 * G(n): ����Ϊn�����еĲ�ͬ��������������    G(0) = G(1) = 1
	 * F(i, n): ��iΪ���Ĳ�ͬ�����������ĸ���
	 * F(i, n) = G(i-1) * G(n-i)
	 * */
    public int numTrees(int n) {
    	
    	int[] g = new int[n+1];
    	g[0] = 1;
    	g[1] = 1;
    	
    	for(int i = 2; i <= n; i++) {
    		for(int j = 1; j <= i; j++) {
    			g[i] += g[j-1] * g [i-j];
    		}
    	}
    	
    	return g[n];
    }
    /*
	 * 98 ��֤����������
	 * ��ȡ�������
	 * */
    public boolean isValidBST(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode node = root;
    	double last = -Double.MAX_VALUE;
    	
    	while(node != null || !stack.isEmpty()) {
    		
    		while(node != null) {
    			stack.add(node);
    			node = node.left;
    		}
    		
    		node = stack.pop();
    		// ���������ظ�ֵ
    		if(node.val <= last) {
    			return false;
    		}
    		last = node.val;
    		node = node.right;
    	}
    	return true;
    }
    
    /*
     * 99 �ָ�����������
     * 	ͨ���������
     * */
    public void recoverTree(TreeNode root) {
        
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode node = root;
    	
    	// ��¼�����Ľڵ����һ�εĽڵ�
    	TreeNode x = null;
    	TreeNode y = null;
    	TreeNode last = null;
    
    	while(node != null || !stack.isEmpty()) {
    		
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		
    		node = stack.pop();
    		
    		// ��һ������x y������������Ѱ��x y 
    		if(last != null && node.val < last.val) {
    			y = node;
    			if(x == null) {
    				x = last;
    			}else {
    				break;
    			}
    		}
    		last = node;
    		node = node.right;
    	}
    	
    	// swap x.val y.val
    	int temp = x.val;
    	x.val = y.val;
    	y.val = temp;
    }
    
    /*
     * 100 ��ͬ����
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {

    	if(p == null && q == null) {
    		return true;
    	}
    	if(p == null || q == null) {
    		return false;
    	}
    	System.out.println(p.val);
    	System.out.println(q.val);
    	if(p.val != q.val) {
    		return false;
    	}
    	boolean left = isSameTree(p.left, q.left);
    	boolean right = isSameTree(p.right, q.right);
    	
    	return left && right;
    }
    
    /*
     * 101 �Գƶ�����
     * */
    public boolean isSymmetric(TreeNode root) {
    	
    	return isSymmetricHelp(root, root);
    }
    public boolean isSymmetricHelp(TreeNode p, TreeNode q) {
    	
    	if(p == null && q == null) {
    		return true;
    	}
    	if(p == null || q == null) {
    		return false;
    	}
    	if(p.val != q.val) {
    		return false;
    	}
    	boolean l = isSymmetricHelp(p.left, q.right);
    	boolean r = isSymmetricHelp(p.right, q.left);
    	return l && r;
    }
    
    /*
     * 105 ǰ��������������й��������
     * ����û���ظ���Ԫ��
     * */
    private int[] preorder;
    private int[] inorder;
    // ����inorder��index
    private HashMap<Integer, Integer> map = new HashMap<>();
    // ����preorder
    private int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	this.preorder = preorder;
    	this.inorder = inorder;
    	
    	for(int i = 0; i < inorder.length; i++) {
    		map.put(inorder[i], i);
    	}
    	
    	return buildTreeHelp(0, inorder.length);
    }
    public TreeNode buildTreeHelp(int start, int end) {
    	
    	if(start == end) {
    		return null;
    	}
    	
    	TreeNode node = new TreeNode(preorder[preIndex]);
    	
    	int inIndex = map.get(preorder[preIndex]);
    	
    	preIndex++;
    	
    	node.left = buildTreeHelp(start, inIndex);
    	node.right = buildTreeHelp(inIndex + 1, end);
    	
    	return node;
    }
    
    /*
     * 106 ����������������й��������
     * ����û���ظ���Ԫ��
     * */
    
    
    /*
     * 108 ����������ת��Ϊƽ�����������
     * */
    public int[] nums; 
    public TreeNode sortedArrayToBST(int[] nums) {

    	this.nums = nums;
    	
    	return sortedArrayToBSTHelp(0, nums.length-1);
    }
    public TreeNode sortedArrayToBSTHelp(int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	
    	int index = (start + end) / 2;
    	
    	TreeNode node = new TreeNode(nums[index]);
    	node.left = sortedArrayToBSTHelp(start, index-1);
    	node.right = sortedArrayToBSTHelp(index+1, end);
    	return node;
    }
    
    /*
     * 110 ƽ�������
     * */
    public int depth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = depth(root.left);
    	int right = depth(root.right);
    	
    	return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
    	
    	if(root == null) {
    		return true;
    	}
    	
    	return Math.abs(depth(root.left) - depth(root.right)) <= 1
    			&& isBalanced(root.left)
    			&& isBalanced(root.right);

    }

    /*
     * 111 ��С���
     * */
    public int minDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return 1;
    	}
    	
    	int min = Integer.MAX_VALUE;
    	if(root.left != null) {
    		min = Math.min(min, minDepth(root.left));
    	}
    	if(root.right != null) {
    		min = Math.min(min, minDepth(root.right));
    	}
    	
    	return min + 1;
    }
    /*
     * 112 ·���ܺ��Ƿ����
     * �ݹ�  ����
     * */
    public boolean hasPathSum(TreeNode root, int sum) {

    	if(root == null) {
    		return false;
    	}
    	
    	sum -= root.val;
    	if(root.left == null && root.right == null) {
    		return sum == 0;
    	}
    	return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    
    public boolean hasPathSum1(TreeNode root, int sum) {
    	
    	if(root == null) {
    		return false;
    	}
    	
    	Stack<TreeNode> nodeStack = new Stack<>();
    	// sum-node.val
    	Stack<Integer> sumStack = new Stack<>() ;
    	
    	TreeNode node = root;
    	
    	nodeStack.add(node);
    	sumStack.add(sum - node.val);
    	
    	while(!nodeStack.isEmpty()) {
    		
    		node = nodeStack.pop();
    		int currentSum = sumStack.pop();
    		
    		if(node.left == null && node.right == null && currentSum == 0) {
    			return true;
    		}
    		
    		// ջ : ���Һ���
    		if(node.right != null) {
    			nodeStack.add(node.right);
    			sumStack.add(currentSum - node.right.val);
    		}
    		if(node.left != null) {
    			nodeStack.add(node.left);
    			sumStack.add(currentSum - node.left.val);
    		}
    	}
    	
    	return false;
    }
    
    /*
     * 113 ·���ܺ�
     * */
    
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

    	if(root == null) {
    		return new ArrayList<>();
    	}
    	temp.add(root.val);
    	sum -= root.val;
    	
    	if(root.left == null && root.right == null && sum == 0) {
    		// ������new ArrayList<>(): ���û�У�������temp�ĸı���ı�
    		ans.add(new ArrayList<>(temp));
    	}
    	pathSum(root.left, sum);
    	pathSum(root.right, sum);
    	
    	temp.remove(temp.size() - 1);
    	return ans;
    }
    
    /*
     * 114 ������չ��Ϊ����
     * */
    public void flatten(TreeNode root) {
        while(root != null) {
 			if(root.left == null) {
 				root = root.right;
 			}else {
 				TreeNode lright = root.left;
 				while(lright.right != null) {
 					lright = lright.right;
 				}
 				
 				lright.right = root.right;
 				root.right = root.left;
 				root.left = null;
 				root = root.right;
 			}
 		}
     }
    
    /*
     * 124 ������������·����
     * */
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

    	maxPathSumHelp(root);
    	return max;
    }
    public int maxPathSumHelp(TreeNode root) {
    	
    	if(root == null) {
    		return 0;
    	}
    	
    	// ���������ĺ�С��0ʱ���ض�
    	int left = Math.max(maxPathSumHelp(root.left), 0);
    	int right = Math.max(maxPathSumHelp(root.right), 0);
    	
    	// �Ե�ǰ�ڵ�Ϊ���ڵ�ĺ�
    	int newPath = left + right + root.val;
    	
    	max = Math.max(max, newPath);
    	System.out.println(max);
    	// ���ص�ǰ�ڵ�Ϊ�������ֵ
    	return Math.max(left, right) + root.val;
    }
    
    /*
     * 129 ����Ҷ�ӽڵ�����֮��
     * 1-2-3: 123
     * */
    private int onePath;
    private int allPath;
    public int sumNumbers(TreeNode root) {

    	if(root == null) {
    		return 0;
    	}
    	onePath = onePath * 10 + root.val;
    	if(root.left == null && root.right == null) {
    		allPath += onePath;
    	}
    	sumNumbers(root.left);
    	sumNumbers(root.right);
    	
    	onePath /= 10;
    	return allPath;
    }
    
    public static void main(String[] args) {
    	TreeNode test = new TreeNode();
    	int[] array = {1,2,3};
    	TreeNode root = test.createBinaryTree(array, 0);
    	_Tree t = new _Tree();
    	t.recoverTree(root);
	}
}
