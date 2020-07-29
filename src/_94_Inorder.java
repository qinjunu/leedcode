import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class _94_Inorder {
	List<Integer> ans = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root){
	    inorder(root);
		return ans;
	}
	
	//µÝ¹é
	public void inorder(TreeNode node) {
		if(node != null) {
	    	inorder(node.left);
	    	ans.add(node.val);
	    	inorder(node.right);
	    }
	}
	
	//·ÇµÝ¹é
	public List<Integer> inorderTraversal1(TreeNode root){
		Stack<TreeNode> s = new Stack<>();
		while(!s.empty() || root != null) {
			if(root != null) {
				s.push(root);
				root = root.left;
			}else {
				root = s.pop();
				ans.add(root.val);
				root = root.right;
			}
		}
		return ans;
	}
	
}
