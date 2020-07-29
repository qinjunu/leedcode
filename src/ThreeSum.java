import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	static public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        int left,right;
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++) {
        	if(nums[i] > 0) break;
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	left = i + 1;
        	right = nums.length - 1;
        	while(left < right) {
        		int sum = nums[i] + nums[left] + nums[right];
            	if(sum == 0) {
            		list.add(Arrays.asList(nums[i],nums[left],nums[right]));
            		while(left<right && nums[left] == nums[left+1]) left++;
            		while(left<right && nums[right] == nums[right-1]) right--;
            		left++;
            		right--;
            	}else if(sum < 0) {
            		left++;
            	}else{
            		right--;
            	}
        	}	
        }
		return list;
    }
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

}
