import java.util.Arrays;

public class SortColors {
	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
    public void sortColors(int[] nums) {
    	int n = nums.length;
    	int p0 = 0, p2 = n - 1, cur = 0;
    	while(cur <= p2) {
    		if(nums[cur] == 0) {
    			if(cur != p0) {
        			swap(nums,cur,p0);
    			}else {
    				cur++;
    			}
    			p0++;
    		}
    		else if(nums[cur] == 2) {
    			swap(nums,cur,p2);
    			p2--;
    		}
    		else
    			cur++;
    	}
    }
    public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		SortColors test = new SortColors();
		test.sortColors(nums);
		System.out.println(Arrays.toString(nums));
    }
}
