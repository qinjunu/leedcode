
public class _dp_minDistance {
	
    // ±‡º≠æ‡¿Î-µ›πÈ
	static String s1 = "rad";
	static String s2 = "apple";
    public int dp(int i, int j) {
    	if(i == -1) {
    		return j + 1;
    	}
    	if(j == -1) {
    		return i + 1;
    	}
    	if(s1.charAt(i) == s2.charAt(j)) {
    		return dp(i - 1, j - 1);
    	}else {
    		return Math.min(Math.min(dp(i, j - 1) + 1, dp(i - 1, j) + 1), 
    				dp(i - 1, j - 1) + 1);
    	}
    }
    
    // ∂ØÃ¨πÊªÆ
    public int minDistance(String s1, String s2) {
    	
    	int n1 = s1.length();
    	int n2 = s2.length();
    	
    	int[][] dp = new int[n1+1][n2+1];
    	
    	for(int i = 0; i <= n1; i++) {
    		dp[i][0] = i;
    	}
    	
    	for(int j = 0; j <= n2; j++) {
    		dp[0][j] = j;
    	}
    	
    	for(int i = 1; i <= n1; i++) {
    		for(int j = 1; j <= n2; j++) {
    			if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
    	    		dp[i][j] = dp[i - 1][j - 1];
    	    	}else {
    	    		dp[i][j] =  Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), 
    	    				dp[i - 1][j - 1] + 1);
    	    	}
    		}
    	}
    	
    	return dp[n1][n2];
    }
	public static void main(String[] args) {
		_dp_minDistance test = new _dp_minDistance();
		System.out.println(test.dp(s1.length() - 1, s2.length() - 1));
		System.out.println(test.minDistance(s1, s2));
	}
}
