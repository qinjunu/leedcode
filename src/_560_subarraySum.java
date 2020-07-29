import java.util.Arrays;
import java.util.HashMap;

public class _560_subarraySum {

	// ½èÖúÊı×é
    public int subarraySum(int[] nums, int k) {

    	int[] s = new int[nums.length+1];
    	int count = 0;
    	
    	s[0] = 0;
    	
    	for(int i = 1; i <= nums.length; i++) {
    		s[i] = s[i-1] + nums[i-1];
    	}
    	
    	System.out.println(Arrays.toString(s));
    	
    	for(int i = 0; i < s.length-1; i++) {
    		for(int j = i+1; j < s.length; j++) {
    			if(s[j] - s[i] == k) {
    				count++;
    			}
    		}
    	}
    	
    	return count;
    }
    // ½èÖúhashmap
    public int subarraySum1(int[] nums, int k) {
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	map.put(0, 1);
    	
    	int count = 0;
    	int sum = 0;
    	for(int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if(map.containsKey(sum - k)) {
    			count += map.get(sum - k);
    		}
    		map.put(sum, map.getOrDefault(sum, 0) + 1);
    	}
    	
    	return count;
    }
    public static void main(String[] args) {
    	_560_subarraySum test = new _560_subarraySum();
    	int[] nums = {0,1,1};
    
    	System.out.println(test.subarraySum1(nums, 0));
    	
	}
}
