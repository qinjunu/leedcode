import java.util.Arrays;

public class _287_findDuplicate {

    public int findDuplicate(int[] nums) {

    	Arrays.sort(nums);
    	
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] == nums[i-1]) {
    			return nums[i];
    		}
    	}
    	
    	return 0;
    }
}
