import java.util.HashMap;
import java.util.Map;

public class _136_singleNumber {
	public int singleNumber(int[] nums) {
		int ans = 0;
		
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(hash.containsKey(nums[i])) {
				hash.remove(nums[i]);
			}else {
				hash.put(nums[i], i);
			}
		}
		for(int i : hash.keySet()) {
			ans = i;
		}
		return ans;
    }
}
