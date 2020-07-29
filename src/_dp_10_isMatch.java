
public class _dp_10_isMatch {

    public boolean isMatch(String s, String p) {
    
    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    	
    	// 初始化
    	dp[0][0] = true;
    	// 对于 s 为空, p只有偶数是 * 才能匹配成功
    	for(int i = 2; i <= p.length(); i += 2) {
    		if(p.charAt(i-1) == '*') {
    			dp[0][i] = dp[0][i-2];
    		}
    	}
    	for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
    
}
