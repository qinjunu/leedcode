
public class LongestPalindrome {
	// 暴力解 时间复杂度 O(n^3)
	static public boolean is_palindrome(String s) {
		boolean is_pal = true;
		int n = s.length();
		for(int i=0,j=n-1;i<j;i++,j--) {
			if(s.charAt(i) != s.charAt(j)) {
				is_pal = false;
				break;
			}
		}
		return is_pal;
	}
	
	
	static public String longestPalindrome(String s) {
		int n = s.length();
		String subString;
		int max_length = 0;
		String ans = "";
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				subString = s.substring(i,j);
				if(is_palindrome(subString)) {
					if(max_length < subString.length()) {
						max_length = subString.length();
						ans = subString;
					}
				}
			}
		}
		
        return ans;
    }
	// 动态规划 时间复杂度 O(n^2)
	static int expandAroundCenter(String s, int left, int right) {
		while(left>=0 && right<s.length()) {
			if(s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}else {
				break;
			}
		}
		
		return right-left-1;
	}
	
	static  String longestPalindrome1(String s) {
		if (s == null || s.length() < 1) return "";
		int len1,len2,len;
		int start = 0, end = 0;
		for(int i=0; i<s.length(); i++) {
			len1 = expandAroundCenter(s,i,i);
			len2 = expandAroundCenter(s,i,i+1);
			len = Math.max(len1, len2);
			if(end - start < len) {
				start = i - (len-1)/2;
				end = i + len/2;
			}
		}
		
		
		return s.substring(start,end+1);
	}
	
	public static void main(String[] args) {
		String s = "abccba";
//		System.out.println(is_palindrome(s));
//		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome1(s));
	}

}
