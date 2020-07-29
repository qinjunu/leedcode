import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> ans = new ArrayList<>();
    	char[] ch = p.toCharArray();
    	Arrays.sort(ch);
    	for(int i = 0; i < (s.length() - p.length() + 1); i++) {
    		char[] temp = s.substring(i, i+p.length()).toCharArray();
    		Arrays.sort(temp);
    		if(String.valueOf(ch).equals(String.valueOf(temp))) {
    			ans.add(i);
    		}
    	}
    	
    	return ans;
    }
    public static void main(String[] args) {
		char[] a = {'a','b'};
		char[] b = {'a','b'};
		System.out.println(String.valueOf(a).equals(String.valueOf(b)));
		
		String s = "cbaebabacd";
		String p = "abc";
		_438_findAnagrams test = new _438_findAnagrams();
		System.out.println(test.findAnagrams(s, p));
	}
}
