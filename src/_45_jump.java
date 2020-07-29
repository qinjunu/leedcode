
public class _45_jump {

    public int jump(int[] nums) {

    	int n = nums.length;
    	if(n == 0) {
    		return 0;
    	}
    	
    	int[] dp = new int[n];
    	dp[n - 1] = 0;
    	
    	for(int i = n - 2; i >= 0; i--) {
    		int min = n;
    		for(int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
    			min = Math.min(min, dp[j]);
    		}
    		dp[i] = min + 1;
    	}
    	
    	return dp[0];
    }
    public int jump1(int[] nums) {
    	
    	// ��¼��ǰ�����ڿ����ߵ���Զλ��
    	int end = 0;
    	// ����
    	int jump = 0;
    	// ��ǰλ��������������Զ����
    	int farthest = 0;
    	
    	// ֻѭ���� n - 2
    	for(int i = 0; i < nums.length - 1; i++) {
    		farthest = Math.max(farthest, nums[i] + i);
    		if(i == end) {
    			jump++;
    			end = farthest;
    			if(end == nums.length - 1) {
    				return jump;
    			}
    		}
    	}
    	
    	return jump;
    }
}
