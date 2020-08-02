import java.util.Arrays;

public class QuickSort {

	public void quickSort(int[] nums, int low, int high) {
		if(low < high) {
			int i = partition(nums, low, high);
			quickSort(nums, low, i - 1);
			quickSort(nums, i + 1, high);
		}
	}
	
	public int partition(int[] nums, int low, int high) {
		
		int temp = nums[low];
		
		while(low < high) {
			
			while(low < high && nums[high] >= temp) {
				high--;
			}
			nums[low] = nums[high];
			while(low < high && nums[low] <= temp) {
				low++;
			}
			nums[high] = nums[low];
			
		}
		
		nums[low] = temp;
		return low;
	}
	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		int[] nums = {4, 5, 6, 1, 2, 3};
		test.quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
