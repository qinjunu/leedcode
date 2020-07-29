
public class _416_canPartition {

    public boolean canPartition(int[] nums) {

    	int sum = 0;
    	for(int num : nums) {
    		sum += num;
    	}
    	
    	if(sum % 2 != 0) {
    		return false;
    	}
    	
    	int half = sum / 2;
    	boolean[] dp = new boolean[half+1];
    	dp[0] = true;
    	if(nums[0] <= half) {
    		dp[nums[0]] = true;
    	}
    	
    	for(int i = 1; i < nums.length; i++) {
    		for(int j = half; nums[i] <= j; j--) {
    			
    			if(dp[half]) {
    				return true;
    			}
    			
    			dp[j] = dp[j] ||dp[j - nums[i]];
    			
    		}
    	}
    	return dp[half];
    }
    public static void main(String[] args) {
    	_416_canPartition test = new _416_canPartition();
    	int[] nums = {1,2,5};
    	boolean ans = test.canPartition(nums);
    	System.out.println(ans);
	}
}
