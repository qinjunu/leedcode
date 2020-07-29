
public class _494_findTargetSumWays {

	//�������
	int count = 0;
	public void BF(int[] nums, int i, int sum, int S) {
		
		if(i == nums.length) {
			if(sum == S) {
				count++;
			}
		}else {
			BF(nums, ++i, sum + nums[i], S);
			BF(nums, ++i, sum - nums[i], S);
		}

	}
    public int findTargetSumWays(int[] nums, int S) {
    	
    	BF(nums, 0, 0, S);
    	return count;
    }
	/*
	 *     ��̬�滮 
	 * dp[i][j]:��ʾǰi��Ԫ�ع���j�ĸ���
	 * dp[i][j] = dp[i-1][j-nums[i]] + dp[i][j+nums[i]]
	 */
    
    public int findTargetSumWays1(int[] nums, int S) {
    	
    	//����numsԪ�ؼӼ����max
    	int sum = 0;
    	for(int num : nums) {
    		sum += num;
    	}
    	
    	if(Math.abs(S) > Math.abs(sum)) {
    		return 0;
    	}
    	int len = sum * 2 + 1;
    	int[][] dp = new int[nums.length][len];
    	
    	//��ʼ��  ��������ֵnums[0] = 0
    	if(nums[0] == 0) {
    		dp[0][sum] = 2; 
    	}else {
    		dp[0][sum + nums[0]] = 1;
    		dp[0][sum - nums[0]] = 1;
    	}
    	
    	for(int i = 1; i < nums.length; i++) {
    		for(int j = 0; j < len; j++) {
    			
    			int left = j - nums[i] < 0 ? 0 : dp[i-1][j-nums[i]];
    			int right = j + nums[i] >= len ? 0 : dp[i-1][j+nums[i]];
    			dp[i][j] = left + right;
    		}
    	}
    	return dp[nums.length-1][S+sum];
    }
    public static void main(String[] args) {
    	int sum = 0;
    	
    
		System.out.println(Math.abs(sum) > Math.abs(2));
		
		
	}
}
