import java.util.HashMap;

public class _105_buildTree {

	int[] preorder;
	int[] inorder;
	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	int preIndex = 0;
	public TreeNode helper(int inleft, int inright) {
		
		if(inleft == inright) return null;
		
		TreeNode root = new TreeNode(preorder[preIndex]);
		int inIndex = hash.get(preorder[preIndex]);
		
		preIndex++;
		
		root.left = helper(inleft, inIndex);
		root.right = helper(inIndex+1, inright);
		
		return root;
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	this.preorder = preorder;
    	this.inorder = inorder;
    	int index = 0;
    	for(int var : inorder) {
    		hash.put(var, index++);
    	}
        return helper(0, inorder.length);
    }
}
