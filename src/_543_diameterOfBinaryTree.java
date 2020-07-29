
public class _543_diameterOfBinaryTree {

	int ans;
    public int diameterOfBinaryTree(TreeNode root) {

    	if(root == null) {
    		return 0;
    	}
    	
    	ans = 1;
    	depth(root);
    	
    	return ans - 1;
    }
    public int depth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = depth(root.left);
    	int right = depth(root.right);
    	
    	ans = Math.max(ans, left + right + 1);
    	return Math.max(left, right) + 1;
    }
}
