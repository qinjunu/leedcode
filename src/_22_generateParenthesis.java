import java.util.ArrayList;
import java.util.List;

public class _22_generateParenthesis {

	List<String> ans = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		
		backtrack(n, 0, 0, "");
		
		return ans;
	}
	
	public void backtrack(int n, int open, int close, String track) {
		
		if(track.length() == 2*n) {
			ans.add(track);
			return;
		}
		
		if(open < n) {
			backtrack(n, open + 1, close, track + "(");
		}
		if(close < open)
		{
			backtrack(n, open, close + 1, track + ")");
		}
		
	}
	public static void main(String[] args) {
		_22_generateParenthesis test = new _22_generateParenthesis();
		
	}
}
