import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring {
	// ����һ
	static int lengthOfLongestSubstring(String s) {
		if(s.equals("")) {
			return 0;
		}
		String subString;
		char c;
		int maxtemp = 1;
		int max = 1;
		for(int i=0; i<s.length()-1; i++) {
			maxtemp = 1;
			for(int j=i+1; j<s.length(); j++) {
				subString = s.substring(i, j);
				c = s.charAt(j);
				if(subString.indexOf(c) == -1) { 
					maxtemp ++;
					continue;
				}else {
					break;
				}
			}
			if(maxtemp > max) {
				max = maxtemp;
			}	
		}
		
		return max;
	}
	// ������  ��������
	static int lengthOfLongestSubstring1(String s) {
		int ans = 0;
		int n = s.length();
		Set<Character> set = new HashSet<>(); 
		int i = 0,j = 0;
		while(i<n && j<n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans,set.size());
			}else {
				set.remove(s.charAt(i++));	
			}
		}
		return ans;
	}
	// ������ �Ż��Ļ�������(�ټ�⵽�����к�����һ��Ԫ�أ����ٴӵ�һ����ʼ�Ƚϣ�ֱ��������Ԫ��λ�ú�)
	static int lengthOfLongestSubstring2(String s) {
		int ans = 0;
		int n = s.length();
		Map<Character,Integer> map = new HashMap<>();
		for(int j=0,i=0; j<n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(i,map.get(s.charAt(j)));
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		String str = "absabs";
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(lengthOfLongestSubstring1(str));
		System.out.println(lengthOfLongestSubstring2(str));
	}

}
