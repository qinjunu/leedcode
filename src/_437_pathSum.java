import java.util.HashMap;
import java.util.Map;

public class _437_pathSum {

    public int pathSum(TreeNode root, int sum) {

    	Map<Integer, Integer> prefixSumCount = new HashMap<>();
    	
    	//һ��Ҫ����0��ǰ׺
    	prefixSumCount.put(0, 1);
    	
    	return recursionPathSum(root, prefixSumCount, sum, 0);
    }
    
    /*
     * ÿ���ڵ㵽���ڵ�·�����ҽ���һ��������ÿ���ڵ㵽��·���ĺͣ����ڵ����Ϊtarget����������
     * prefixSumCount:��¼ǰ׺Ϊkey�ĸ�������Ϊ���ڸ�������ֹһ��
     * currSum:��ǰ�ڵ㵽���ڵ�ĺ�
     * */
    public int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, 
    		int target, int currSum) {

    	if(node == null) {
    		return 0;
    	}

    	//������������·������
    	int res = 0;
    	
    	currSum += node.val;
    	
    	res += prefixSumCount.getOrDefault(currSum - target, 0);
    	//����ǰǰ׺����
    	prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
    	
    	//������һ��
    	res += recursionPathSum(node.left, prefixSumCount, target, currSum);
    	res += recursionPathSum(node.right, prefixSumCount, target, currSum);
    	
    	//�ص����㣬ȥ����ǰ�ڵ��ǰ׺
    	prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
    	
    	return res;
    }
}
