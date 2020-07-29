
public class _337_rob3 {
	
	/*
	 * 节点：爷爷 儿子 孙子
	 * 每个节点所能偷的最大金额
	 * 	  max(自己+孙子， 儿子)
	 * */
    public int rob(TreeNode root) {

    	if(root == null) {
    		return 0;
    	}
    	
    	int money = root.val;
    
    	if(root.left != null) {
    		money += (rob(root.left.left) + rob(root.left.right)); 
    	}
    	
    	if(root.right != null) {
    		money += (rob(root.right.left) + rob(root.right.right));
    	}
    	
    	money = Math.max(money, rob(root.left) + rob(root.right));
    	return money;
    }
}
