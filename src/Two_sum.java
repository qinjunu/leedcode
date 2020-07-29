import java.util.Arrays;
import java.util.HashMap;

public class Two_sum {

	static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		for(int i=0 ; i<nums.length ; i++) {
			for(int j=i+1 ; j<nums.length ; j++) {
				if((nums[i] + nums[j]) == target ) {
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
		
		return ans;   
    }
	static int[] twoSum1(int[] nums, int target) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		int temp = 0;
		for(int i=0; i<nums.length; i++ ) {
			temp = target - nums[i];
			if(hm.containsKey(temp) && hm.get(temp) != i) {
				return new int[] {hm.get(temp),i};
			}
			hm.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] ans = new int[2];
		ans = twoSum(nums,target);
		System.out.println(twoSum(nums,target));
		System.out.println(twoSum1(nums,target));
		System.out.println(Arrays.toString(twoSum1(nums,target)));
	}
	

}
