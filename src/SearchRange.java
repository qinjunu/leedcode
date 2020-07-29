import java.util.Arrays;

public class SearchRange {
	
	static public int[] searchRange(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		int[] ans = {-1,-1};
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				int temp = mid;
				while(temp >= 0 && nums[temp] == target) {
					ans[0] = temp--;
				}
				temp = mid;
				while(temp < nums.length && nums[temp] == target) {
					ans[1] = temp++;
				}
				break;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return ans;
    }
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(Arrays.toString(searchRange(nums,1)));
	}

}
