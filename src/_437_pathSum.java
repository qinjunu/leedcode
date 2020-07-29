import java.util.HashMap;
import java.util.Map;

public class _437_pathSum {

    public int pathSum(TreeNode root, int sum) {

    	Map<Integer, Integer> prefixSumCount = new HashMap<>();
    	
    	//一定要存入0的前缀
    	prefixSumCount.put(0, 1);
    	
    	return recursionPathSum(root, prefixSumCount, sum, 0);
    }
    
    /*
     * 每个节点到根节点路径有且仅有一条，保存每个节点到根路径的和，两节点相差为target即满足条件
     * prefixSumCount:记录前缀为key的个数，因为存在负数，不止一个
     * currSum:当前节点到根节点的和
     * */
    public int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, 
    		int target, int currSum) {

    	if(node == null) {
    		return 0;
    	}

    	//保存满足条件路径个数
    	int res = 0;
    	
    	currSum += node.val;
    	
    	res += prefixSumCount.getOrDefault(currSum - target, 0);
    	//将当前前缀保存
    	prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
    	
    	//进入下一层
    	res += recursionPathSum(node.left, prefixSumCount, target, currSum);
    	res += recursionPathSum(node.right, prefixSumCount, target, currSum);
    	
    	//回到本层，去除当前节点的前缀
    	prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
    	
    	return res;
    }
}
