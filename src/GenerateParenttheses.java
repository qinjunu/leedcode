import java.util.ArrayList;
import java.util.List;

public class GenerateParenttheses {

	//方法一：暴力求解
	static public List<String> generateParenthesis(int n) {
      
		List<String> ans = new ArrayList<>();
		generateAll(ans,new char[2*n],0);
		
		return ans;
    }
	static public void generateAll(List<String> ans,char[] current,int pos) {
		if(pos == current.length) {
			if(valid(current))
				ans.add(new String(current));
		}else {
			current[pos] = '(';
			generateAll(ans,current,pos+1);
			current[pos] = ')';
			generateAll(ans,current,pos+1);
		}
	}
	static public boolean valid(char[] current) {
		int balance = 0;
		for(char c:current) {
			if(c == '(') {
				balance++;
			}else {
				balance--;
			}
			if(balance < 0)
				break;
		}
		return balance == 0;
	}
	
	
	//backtrack
	static public void backTrack(List<String> ans,int open,int close,
			int n,String current) {
		if(current.length() == 2*n) {
			ans.add(current);
		}else {
			if(open < n) {
				backTrack(ans,open+1,close,n,current+"(");
			}
			if(close < open) {
				backTrack(ans,open,close+1,n,current+")");
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));

	}

}
