
public class _114_flatten {

	//·½·¨Ò»
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


}
