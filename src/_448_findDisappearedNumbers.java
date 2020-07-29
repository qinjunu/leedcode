import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _448_findDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {

    	List<Integer> ans = new ArrayList<>();
    	
    	HashSet<Integer> set = new HashSet<>();
    	
    	for(int num : nums) {
    		set.add(num);
    	}
    	
    	for(int i = 1; i <= nums.length; i++) {
    		if(!set.contains(i)) {
    			ans.add(i);
    		}
    	}
    	
    	return ans;
    	
    }
}
