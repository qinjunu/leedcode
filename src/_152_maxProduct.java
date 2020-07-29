
public class _152_maxProduct {
    public int maxProduct(int[] nums) {

    	int max = Integer.MIN_VALUE;
    	int curmax = 1;
    	int curmin = 1;
    	
    	for (int num : nums) {
    		if(num < 0) {
    			int temp = curmax;
    			curmax = curmin;
    			curmin = temp;
    		}
    		curmax = Math.max(curmax*num, num);
    		curmin = Math.min(curmin*num, num);
    		max = Math.max(curmax, max);
    		System.out.println(max);
    	}
    	
    	return max;
    }
    public static void main(String[] args) {
    	_152_maxProduct test = new _152_maxProduct();
		int[] nums = {2,3,-2,4};
		System.out.println(test.maxProduct(nums));
	}
}
