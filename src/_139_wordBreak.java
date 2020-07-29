import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_wordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        System.out.println(Arrays.toString(memo));
        return memo[start] = false;
    }
    public static void main(String[] args) {
		String str = "catsandog";
		List<String> list = new ArrayList<>();
		list.add("cats");
		list.add("dog");
		list.add("cat");
		list.add("sand");
		list.add("and");
		//list.add("aaaaaa");
		
		_139_wordBreak test = new _139_wordBreak();
		System.out.println(test.wordBreak(str, list));
	}
}
