import java.util.ArrayList;
import java.util.List;

public class _backtrack {

	List<List<Integer>> ans = new ArrayList<>();
	 
	public List<List<Integer>> permutation(int[] nums){
		
		List<Integer> track = new ArrayList<>();
		backtrack(nums, track);
		
		return ans;
	}
	public void backtrack(int[] nums, List<Integer> track) {
		
		if(track.size() == nums.length) {
			ans.add(new ArrayList<>(track));
			return;
		}
		
		for(int num : nums) {
			if(track.contains(num)) {
				continue;
			}
			track.add(num);
			backtrack(nums, track);
			track.remove(track.size() - 1);
		}
		
	}
	public static void main(String[] args) {
		_backtrack test = new _backtrack();
		int[] nums = {1,2,3};
		for(List<Integer> l : test.permutation(nums)) {
			System.out.println(l);
		}
	}
}
