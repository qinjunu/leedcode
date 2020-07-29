import java.util.Arrays;

public class _215_findKthLargest {
	
    public int findKthLargest(int[] nums, int k) {
    	
    	Arrays.sort(nums);
    	
    	return nums[nums.length - k];
    }
	public static void main(String[] args) {
		
		_215_findKthLargest test = new _215_findKthLargest();
		int[] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(test.findKthLargest(nums, 4));
	}

}
