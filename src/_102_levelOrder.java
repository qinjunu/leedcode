import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_levelOrder {
   
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (root == null) return ans;
		
		int level = 0;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			ans.add(new ArrayList<Integer>());
			int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.remove();
				ans.get(level).add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			level++;
		}
		return ans;
    }	
	
	

}
