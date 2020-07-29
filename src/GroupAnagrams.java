import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
        	return new ArrayList<>();
        }
		Map<String, List<String>> map = new HashMap<>();
		for(String s: strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if(!map.containsKey(key)) {
				//先插入一个空列表,随后在继续向空表中添加符合的数据
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
		
    }
	public List<List<String>> groupAnagrams1(String[] strs) {
		if(strs.length == 0) {
        	return new ArrayList<>();
        }
		Map<String, List<String>> map = new HashMap<>();
		int[] count = new int[26];
		for(String s: strs) {
			//用0填充数组
			Arrays.fill(count, 0);
			for(char c: s.toCharArray()) {
				count[c-'a']++;
			}
			StringBuilder sb = new StringBuilder("");
			for(int i=0; i<26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if(!map.containsKey(key)) {
				//先插入一个空列表,随后在继续向空表中添加符合的数据
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}
}
