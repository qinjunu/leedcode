import java.util.Arrays;

public class _283_moveZeroes {

    public void moveZeroes(int[] nums) {

    	int i = 0;
    	while(i < nums.length) {
    		if(nums[i] != 0) {
    			i++;
    			continue;
    		}
    		int zeroNum = 0;
    		for(int j = i; j < nums.length; j++) {
    			if(nums[j] == 0) {
    				zeroNum++;
    			}else {
    				break;
    			}
    		}
    		for(int k = i; k < nums.length - zeroNum; k++) {
    			nums[k] = nums[k+zeroNum];
    		}
    		for(int l = nums.length - zeroNum; l < nums.length; l++) {
    			nums[l] = 0;
    		}
    		i++;
    	}
    	System.out.println(Arrays.toString(nums));
    	
    }
    
    //¿ìÂýÖ¸Õë
    public void moveZeroes1(int[] nums) {
    	
    	for(int slow = 0, fast = 0; fast < nums.length; fast++) {
    		if(nums[fast] != 0) {
    			int temp = nums[fast];
    			nums[fast] = nums[slow];
    			nums[slow++] = temp;
    			
    		}
    	}
    	
    }
    public static void main(String[] args) {
		int[] nums = {4,2,4,0,0,3,0,5,1,0};
		_283_moveZeroes test = new _283_moveZeroes();
		test.moveZeroes1(nums);
		System.out.println(Arrays.toString(nums));
    }
}
