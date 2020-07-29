import java.util.Arrays;

public class _300_lengthOfLIS {

    public int lengthOfLIS(int[] nums) {

    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	int max = 1;

    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
    	
    	for(int i = 1; i < nums.length; i++) {
    		for(int j = i-1; j >= 0; j--) {
    			if(nums[j] < nums[i]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    				max = Math.max(max, dp[i]);
    			}
    		}
    	}
    	System.out.println(Arrays.toString(dp));
    	return max;
    }
    public static void main(String[] args) {
    	_300_lengthOfLIS test = new _300_lengthOfLIS();
    	int[] nums = {1,3,6,7,9,4,10,5,6};
    	System.out.println(test.lengthOfLIS(nums));
	}
}
