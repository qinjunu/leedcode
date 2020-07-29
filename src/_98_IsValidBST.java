import java.util.Stack;

public class _98_IsValidBST {
	public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        double border = - Double.MAX_VALUE;
        
        while(!s.isEmpty() || root != null) {
        	while(root != null) {
        		s.add(root);
        		root = root.left;
        	}
        	
        	root = s.pop();
        	if(root.val <= border) {
        		return false;
        	}
        	
        	border = root.val;
        	root = root.right;
        }
        
		return true;
    }
}
