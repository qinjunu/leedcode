import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * ������������(����ָ��)
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * */
public class _slidingWindow {

	/* ���������㷨���*/
	public void slidingWindow(String s, String t) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		//��ʼ����ָ�� ����ҿ�
		int left = 0, right = 0;
		//window������ need �������ַ�����
		int valid = 0;
		
		while(right < s.length()) {
			// ��¼�����봰�ڵ��ַ�
			char c  = s.charAt(right);
			// ���ƴ���
			right++;
			// ���и���
			
			// debug
			System.out.println(left + " " + right);
			
			// �ж���ര���Ƿ���Ҫ����(������д��������)
			while(true) {
				// ��¼��Ҫ�Ƴ����ַ�
				char d = s.charAt(left);
				// ���ƴ���
				left++;
				// ���и���
				
			}
		}
	}
	/*76 ��С�����Ӵ�*/
    public String minWindow(String s, String t) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		for(char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0;
		int valid = 0;
		
		// ��¼��С�����Ӵ��ĳ�ʼλ���볤��
		int start = 0;
		int length = Integer.MAX_VALUE;
		

		while(right < s.length()) {
			char c  = s.charAt(right);
			right++;
			// ���и���
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			// �ж���ര���Ƿ���Ҫ����(������д��������)
			// ��window�����а������е�need
			while(valid == need.size()) {
				
				// ����start length
				if(right - left < length) {
					start = left;
					length = right - left;
				}
				
				char d = s.charAt(left);
				left++;
				// ���и���
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
     * 567 �ַ���������
     * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 ������
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
			// ���и���
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			// �ж���ര���Ƿ���Ҫ����(������д��������)
			// �����ڳ��ȴ���s1.length
			while(right - left == s1.length()) {
				
				if(valid == need.size()) {
					return true;
				}
				
				char d = s2.charAt(left);
				left++;
				// ���и���
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
     * 438 �ҵ��ַ�����������ĸ��λ��
     * ����:s: "cbaebabacd" p: "abc"
     * ���:[0, 6]
     * */
    public List<Integer> findAnagrams(String s, String p) {

		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		
		for(char c : p.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		//��ʼ����ָ�� ����ҿ�
		int left = 0, right = 0;
		//window������ need �������ַ�����
		int valid = 0;
		
		List<Integer> ans = new ArrayList<>();
		
		while(right < s.length()) {
			// ��¼�����봰�ڵ��ַ�
			char c  = s.charAt(right);
			// ���ƴ���
			right++;
			// ���и���
			if(need.containsKey(c)){			
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).compareTo(window.get(c)) == 0) {
					valid++;
				}
			}
			
			// �ж���ര���Ƿ���Ҫ����(������д��������)
			while(right - left == p.length()) {
				
				if(valid == need.size()) {
					ans.add(left);
				}
				// ��¼��Ҫ�Ƴ����ַ�
				char d = s.charAt(left);
				// ���ƴ���
				left++;
				// ���и���
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
     * 3 ���ظ���Ӵ�
     * ��һ���ַ����ϲ���
     * ����hashset,˫ָ��
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
