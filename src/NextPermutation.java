import java.util.Arrays;

public class NextPermutation {
	static public int  min(int[] nums, int index) {
		
		for(int i = nums.length-1; i >= index; i--) {
			if(nums[i] > nums[index-1])
				return i;
		}
		return index;
	}
	
	static public void reverse(int[] nums, int index) {
		for(int i = index, j = 1; i < index+(nums.length-index)/2;
				i++,j++) {
			int temp = nums[i];
    		nums[i] = nums[nums.length-j];
    		nums[nums.length-j] = temp;
    
		}
	}
    static public void nextPermutation(int[] nums) {
    	int i = nums.length - 1;
    	for( ; i > 0; i--) {
    		if(nums[i] > nums[i-1]) {
    			int min_index = min(nums,i);
        		int temp = nums[min_index];
        		nums[min_index] = nums[i-1];
        		nums[i-1] = temp;
        		reverse(nums,i);
        		break;
    		}
    	}
    	if(i == 0) Arrays.sort(nums);
    }
	public static void main(String[] args) {
		int[] nums = {3,2,1};
		System.out.println(min(nums,1));
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
