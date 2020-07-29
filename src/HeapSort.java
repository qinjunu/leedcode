import java.util.Arrays;

public class HeapSort {

	public void buildMaxHeap(int[] nums, int length) {
		
		// 从最后一个非叶子节点依次往前进行遍历
		for(int i = length/2 - 1; i >= 0; i--) {
			adjustDown(nums, i, length);
		}
		
	}
	
	public void adjustDown(int[] nums, int i, int length) {
		
		int temp = nums[i];
		
		for(int j = i * 2 + 1; j < length; j = j * 2 + 1) {
			if(j + 1 < length && nums[j] < nums[j+1]) {
				j++;
			}
			if(temp < nums[j]) {
				nums[i] = nums[j];
				i = j;
			}else {
				break;
			}
		}
		
		nums[i] = temp;
	}
	
	public void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	
	}
	
	public void heapSort(int[] nums) {
		buildMaxHeap(nums, nums.length);
		for(int i = nums.length - 1; i > 0; i--) {
			swap(nums, 0, i);
			buildMaxHeap(nums, i);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		
		HeapSort test = new HeapSort();	
		test.heapSort(nums);
		
		System.out.println(Arrays.toString(nums));
 	}
	
}
