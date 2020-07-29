import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 滑动窗口问题(左右指针)
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * */
public class _slidingWindow {

	/* 滑动窗口算法框架*/
	public void slidingWindow(String s, String t) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		//初始左右指针 左闭右开
		int left = 0, right = 0;
		//window中满足 need 条件的字符个数
		int valid = 0;
		
		while(right < s.length()) {
			// 记录将移入窗口的字符
			char c  = s.charAt(right);
			// 右移窗口
			right++;
			// 进行更新
			
			// debug
			System.out.println(left + " " + right);
			
			// 判断左侧窗口是否需要更新(括号里写更新条件)
			while(true) {
				// 记录将要移除的字符
				char d = s.charAt(left);
				// 左移窗口
				left++;
				// 进行更新
				
			}
		}
	}
	/*76 最小覆盖子串*/
    public String minWindow(String s, String t) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		for(char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0;
		int valid = 0;
		
		// 记录最小覆盖子串的初始位置与长度
		int start = 0;
		int length = Integer.MAX_VALUE;
		

		while(right < s.length()) {
			char c  = s.charAt(right);
			right++;
			// 进行更新
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			// 判断左侧窗口是否需要更新(括号里写更新条件)
			// 在window窗口中包含所有的need
			while(valid == need.size()) {
				
				// 更新start length
				if(right - left < length) {
					start = left;
					length = right - left;
				}
				
				char d = s.charAt(left);
				left++;
				// 进行更新
				if(need.containsKey(d)) {
					if(need.get(d) == window.get(d)) {
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
				
			}
		}
		return length == Integer.MAX_VALUE ? "" :
			s.substring(start, start + length);
    }
    /*
     * 567 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列
     * */
    public boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		for(char c : s1.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0;
		int valid = 0;

		while(right < s2.length()) {
			char c  = s2.charAt(right);
			right++;
			// 进行更新
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			// 判断左侧窗口是否需要更新(括号里写更新条件)
			// 当窗口长度大于s1.length
			while(right - left == s1.length()) {
				
				if(valid == need.size()) {
					return true;
				}
				
				char d = s2.charAt(left);
				left++;
				// 进行更新
				if(need.containsKey(d)) {
					if(need.get(d).compareTo(window.get(d)) == 0) {
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
				
			}
		}
		return false;
    }
    /*
     * 438 找到字符串中所有字母异位词
     * 输入:s: "cbaebabacd" p: "abc"
     * 输出:[0, 6]
     * */
    public List<Integer> findAnagrams(String s, String p) {

		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		for(char c : p.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		//初始左右指针 左闭右开
		int left = 0, right = 0;
		//window中满足 need 条件的字符个数
		int valid = 0;
		
		List<Integer> ans = new ArrayList<>();
		
		while(right < s.length()) {
			// 记录将移入窗口的字符
			char c  = s.charAt(right);
			// 右移窗口
			right++;
			// 进行更新
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			
			// 判断左侧窗口是否需要更新(括号里写更新条件)
			while(right - left == p.length()) {
				
				if(valid == need.size()) {
					ans.add(left);
				}
				// 记录将要移除的字符
				char d = s.charAt(left);
				// 左移窗口
				left++;
				// 进行更新
				if(need.containsKey(d)) {
					if(need.get(d).compareTo(window.get(d)) == 0) {
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
			}
		}
    	
    	return ans;
    }
    /*
     * 3 无重复最长子串
     * 在一个字符串上操作
     * 借助hashset,双指针
     * */
    public static void main(String[] args) {
    	_slidingWindow test = new _slidingWindow();
    	String s = "a";
    	String t = "aa";
    	System.out.println(test.minWindow(s, t));
    	Integer i = new Integer(100);
    	Integer j = new Integer(100);
    	System.out.println(i == j);
    	System.out.println(i.equals(j));
    	System.out.println(i.compareTo(j));
    	
	}
}
