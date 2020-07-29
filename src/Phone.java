import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class Phone {
	static List<String> ans = new ArrayList<>();
	static Map<Character,String> keyboard = new HashMap<Character,String>(){
		private static final long serialVersionUID = 1L;

		{
			put('2',"abc");
			put('3',"def");
			put('4',"ghi");
			put('5',"jkl");
			put('6',"mno");
			put('7',"pqrs");
			put('8',"tuv");
			put('9',"wxyz");
		}
	};	
	
	static public void backtrack(String combination,String nextDigits) {
		if(nextDigits.length() == 0) {
			ans.add(combination);
		}else {
			char digit = nextDigits.charAt(0);
			String characters = keyboard.get(digit);
			for(int i = 0; i < characters.length(); i++) {
				String str = characters.substring(i,i+1);
				backtrack(combination + str,nextDigits.substring(1));
			}
		}
	}
	static public List<String> letterCombinations(String digits) {
		if(!digits.isEmpty())
			backtrack("",digits);
		return ans;
    }
	public static void main(String[] args) {
		
		
		String num = "";
		System.out.println(letterCombinations(num));
	
	}

}
