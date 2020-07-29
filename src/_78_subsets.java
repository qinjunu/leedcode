import java.util.ArrayList;
import java.util.List;

public class _78_subsets {
	
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

    	if(nums.length == 0) {
    		return new ArrayList<>();
    	}
    	List<Integer> track = new ArrayList<>();
    	backtrack(nums, 0, track);
    	
    	return ans;
    }
    public void backtrack(int[] nums, int start, List<Integer> track) {
    	
    	ans.add(new ArrayList<>(track));
    	
    	for(int i = start; i < nums.length; i++) {
    		track.add(nums[i]);
    		backtrack(nums, i + 1, track);
    		track.remove(track.size() - 1);
    	}
    }
    public static void main(String[] args) {
    	_78_subsets test = new _78_subsets();
		int[] nums = {1,2,3};
		test.subsets(nums);
	
	}
}
