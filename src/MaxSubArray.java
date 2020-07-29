
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num : nums) {
        	if(sum > 0) {
        		sum += num;
        	}else {
        		sum = num;
        	}
        	ans = Math.max(ans, sum);
        }
		return ans;
    }
	public static void main(String[] args) {
		MaxSubArray msa = new MaxSubArray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int ans = msa.maxSubArray(nums);
		System.out.println(ans);
	}
}
