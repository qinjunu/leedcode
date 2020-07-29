import java.util.LinkedList;
import java.util.Queue;

public class _226_invertTree {

	//µÝ¹é
    public TreeNode invertTree(TreeNode root) {

    	if(root == null) {
    		return null;
    	}
    	
    	TreeNode left = invertTree(root.left);
    	TreeNode right = invertTree(root.right);
    	
    	root.left = right;
    	root.right = left;
    	
    	return root;
    }
    //µü´ú
    public TreeNode invertTree1(TreeNode root) {

    	if(root == null) {
    		return null;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		
    		TreeNode node = queue.poll();
    		TreeNode temp = node.left;
    		node.left = node.right;
    		node.right = temp;
    		
    		if(node.left != null) {
    			queue.add(node.left);
    		}
    		if(node.right != null) {
    			queue.add(node.right);
    		}
    	}
    	
    	return root;
    }
}
