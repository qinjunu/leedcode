
public class _236_lowestCommonAncestor {

	private TreeNode ans;
	
	public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) {
			return false;
		}
		
		boolean left = helper(root.left, p, q);
		boolean right = helper(root.right, p, q);
		boolean mid = (root.val == p.val || root.val == q.val);
		
		if(mid ? (left || right) : (left && right)) {
			ans = root;
		}
		
		return left || right || mid;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		helper(root, p, q);
    	
    	return ans;
    }
    
}
