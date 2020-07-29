package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){
		val = x;
	}
	public TreeNode() {}
	//构建二叉树
    public TreeNode createBinaryTree(int[] array, int index){
    	
        TreeNode node = null;
        if(index < array.length) {
        	if(array[index] != 0) {
        		node = new TreeNode(array[index]);
        	}else {
        		return node;
        	}
        	node.left = createBinaryTree(array, 2*index+1);
        	node.right = createBinaryTree(array, 2*index+2);
        }
        return node;
    }
    
    /*
     * 先序遍历
     * 递归
     * 非递归
     * */
    public void preOrderTraversal(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	System.out.print(root.val + " ");
    	preOrderTraversal(root.left);
    	preOrderTraversal(root.right);
    }
    public void preOrderTraversal1(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode node = root;
    	
    	while(node != null || !stack.isEmpty()) {
    		while(node != null) {
    			System.out.print(node.val + " ");
    			stack.add(node);
    			node = node.left;
    		}
			node = stack.pop();
			node = node.right;
    	}
    }
    
    /*
     * 中序遍历
     * 递归
     * 非递归
     * */
    public void inOrderTraversal(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	inOrderTraversal(root.left);
    	System.out.print(root.val + " ");
    	inOrderTraversal(root.right);
    }
    
    public void inOrderTraversal1(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode node = root;
    	
    	while(node != null || !stack.isEmpty()) {
    		while(node != null) {
    			
    			stack.add(node);
    			node = node.left;
    		}
			node = stack.pop();
			System.out.print(node.val + " ");
			node = node.right;
    	}
    }
    /*
     * 后序遍历
     * 递归
     * 非递归
     * */
    public void postOrderTraversal(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	postOrderTraversal(root.left);
    	postOrderTraversal(root.right);
    	System.out.print(root.val + " ");
    }
    
    public void postOrderTraversal1(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode node = root;
    	// 记录上一个visit节点
    	TreeNode lastVisit = root;
    	
    	while(node != null || !stack.isEmpty()) {
    		
    		while(node != null) {
    			stack.add(node);
    			node = node.left;
    		}
    		
    		node = stack.peek();
    		
    		// 如果右节点为null 或者  右节点为上一次访问过的节点   访问该节点
    		if(node.right == null || node.right == lastVisit) {
    			System.out.print(node.val + " ");
    			lastVisit = node;
    			stack.pop();
    			node = null;
    		}else {
    			node = node.right;
    		}	
    	}
    }
    
    /*
     * 层次遍历
     * */
    public void levelOrderTraversal(TreeNode root) {
    	
    	if(root == null) {
    		return;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	TreeNode node = root;
    	queue.add(node);
    	
    	while(!queue.isEmpty()) {
    		node = queue.poll();
			System.out.print(node.val + " ");
			if(node.left != null) {
				queue.add(node.left);
			}
    		if(node.right != null) {
    			queue.add(node.right);
    		}
    	}
    	
    }
    // 记录每层数据
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null) {
    		return new ArrayList<>();
    	}
    	List<List<Integer>> ans = new ArrayList<>();
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	TreeNode node = root;
    	queue.add(node);
    	
    	while(!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<>();
    		int len = queue.size();
    		for(int i = 0; i < len; i++) {
    			node = queue.poll();
        		level.add(node.val);
        		if(node.left != null) {
        			queue.add(node.left);
        		}
        		if(node.right != null) {
        			queue.add(node.right);
        		}
    		}
    		System.out.println(Arrays.toString(level.toArray()));
    		ans.add(0, level);
    	}
    	return ans;
    }
    
    // 锯齿形层次遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    	if(root == null) {
    		return new ArrayList<>();
    	}
    	List<List<Integer>> ans = new ArrayList<>();
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	TreeNode node = root;
    	
    	queue.add(node);
    	
    	// 交替
    	boolean tag = true;
    	while(!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<>();
    	    int len = queue.size();
    	    for(int i = 0; i < len; i++) {
    	    	node = queue.poll();
    	    	if(tag) {
    	    		level.add(node.val);
    	    	}else {
    	    		level.add(0, node.val);
    	    	}
    	    	
    	    	if(node.left != null) {
    	    		queue.add(node.left);
    	    	}
    	    	if(node.right != null) {
    	    		queue.add(node.right);
    	    	}
    	    }
    	    tag = !tag;
    	    ans.add(level);
    	}
    	
    	
    	return ans;
    }
    // 树的深度
    public int depth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = depth(root.left);
    	int right = depth(root.right);
    	
    	return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
    	TreeNode test = new TreeNode();
    	int[] array = {1,2,3,4,0,5};
    	TreeNode root = test.createBinaryTree(array, 0);
    	
    	test.preOrderTraversal(root);
    	System.out.println();
    	test.preOrderTraversal1(root);
    	System.out.println();
    	
    	test.inOrderTraversal(root);
    	System.out.println();
    	test.inOrderTraversal1(root);
    	System.out.println();
    	
    	test.postOrderTraversal(root);
    	System.out.println();
    	test.postOrderTraversal1(root);
    	System.out.println();
    	
    	test.levelOrderTraversal(root);
    	System.out.println();
    	
    	System.out.println(test.depth(root));
	}
}