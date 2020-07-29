import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	
	public List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public int[] candidates;
	
	public void backTrack(int start, int target, Stack<Integer> s) {
//		if(target == 0) {
//			ans.add(new ArrayList<Integer>(s));
//			return;
//		}else {
//			for(int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
//				s.push(candidates[i]);
//				backTrack(i,target-candidates[i],s);
//				s.pop();
//			}
//		}
		if(target <=0) {
			if(target == 0) {
				ans.add(new ArrayList<Integer>(s));
			}
			return;
		}else {
			for(int i = start; i < candidates.length; i++) {
				s.push(candidates[i]);
				backTrack(i,target-candidates[i],s);
				s.pop();
			}
		}
		
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates.length == 0) return ans;
		Arrays.sort(candidates);
		
		this.candidates = candidates;
		Stack<Integer> s = new Stack<>();
		backTrack(0, target, s);
		return ans;
    }
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		CombinationSum solution = new CombinationSum();
		List<List<Integer>> ans = solution.combinationSum(candidates, target);
		System.out.println(ans);
	}

}
