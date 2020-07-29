import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute {
	public List<List<Integer>> ans = new ArrayList<>();
	public int[] nums;
	
	public void backTrack(Stack<Integer> s) {
		if(s.size() == nums.length) {
			ans.add(new ArrayList<>(s));
		}else {
			for(int i = 0; i < nums.length; i++) {
				if(!s.contains(nums[i])) {
					s.push(nums[i]);
					backTrack(s);
					s.pop();
				}
			}
		}
	}
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length == 0) return ans;
		
		this.nums = nums;
		backTrack(new Stack<Integer>());
		
		return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans = new ArrayList<>();
		int[] nums = {1,2,3,4};
		Permute p  = new Permute();
		ans = p.permute(nums);
		System.out.println(ans);
	}

}
