import java.util.HashMap;

public class _106_buildTree {

	private int[] inorder;
	private int[] postorder;
	private HashMap<Integer, Integer> map = new HashMap<>();
	private int postIndex;	 
    public TreeNode buildTree(int[] inorder, int[] postorder) {

    	this.inorder = inorder;
    	this.postorder = postorder;
    	this.postIndex = postorder.length - 1;
    	
    	for(int i = 0; i < inorder.length; i++) {
    		map.put(inorder[i], i);
    	}
    	
    	return buildTreeHelp(0, inorder.length);
    }
    public TreeNode buildTreeHelp(int start, int end) {
    	
    	if(start == end) {
    		return null;
    	}
    	
    	TreeNode node = new TreeNode(postorder[postIndex]);
    	
    	int inIndex = map.get(postorder[postIndex]);
    	
    	postIndex--;
    	
    	node.right = buildTreeHelp(inIndex + 1, end);
    	node.left = buildTreeHelp(start, inIndex);
    	
    	return node;
    }

}
