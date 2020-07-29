
public class _dp {

	// 5 最长回文子串
    public String longestPalindrome(String s) {
    	
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	
    	String ans = "";
    	
    	for(int len = 0; len < s.length(); len++) {
    		for(int start = 0; start < s.length() - len; start++) {
    			int end = start + len;
    			if(len == 0) {
    				dp[start][end] = true;
    			}else if(len == 1) {
    				dp[start][end] = s.charAt(start) == s.charAt(end);
    			}else {
    				dp[start][end] = dp[start+1][end-1] && s.charAt(start) == s.charAt(end);
    			}
    			if(dp[start][end] && end - start + 1 > ans.length()) {
    				ans = s.substring(start, end + 1);
    			}
    		}
    		
    	}
    	return ans;
    }
    // 0 - 1 背包
    public int backpack(int N, int W, int[] wt, int[] val) {
    	
    	int[][] dp = new int[N+1][W+1];
    	
    	for(int i = 1; i <= N; i++) {
    		for(int w = 1; w <= W; w++) {
    			if(w - wt[1] < 0) {
    				dp[i][w] = dp[i-1][w];
    			}else {
    				dp[i][w] = Math.max(dp[i-1][w],
    						dp[i-1][w-wt[i-1]] + val[i-1]);
    			}
    		}
    	}
    	return 0;
    }
    // 518 完全背包问题
    public int change(int amount, int[] coins) {

    	int[][] dp = new int[coins.length+1][amount+1];
    	
    	for(int i = 0; i <= coins.length; i++) {
    		dp[i][0] = 1;
    	}
    	
    	for(int i = 1; i <= coins.length; i++) {
    		for(int j = 1; j <= amount; j++) {
    			if(j - coins[i-1] < 0) {
    				dp[i][j] = dp[i-1][j];
    			}else {
    				dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
    			}
    		}
    	}
    	
    	return dp[coins.length][amount];
    }
    
    // 416 分割等和子集
    public boolean canPartition(int[] nums) {
    	
    	int sum = 0;
    	for(int num : nums) {
    		sum += num;
    	}
    	
    	if(sum % 2 != 0) {
    		return false;
    	}
    	
    	int amount = sum / 2;
    	boolean[] dp = new boolean[amount+1];
    	dp[0] = true;
    	
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = amount; j > 0; j--) {
    			if(j - nums[i] >= 0) {
    				dp[j] = dp[j-nums[i]] || dp[j];
    			}
    		}
    		
    	}
    	return dp[amount];
    }
    

    public static void main(String[] args) {
    	_dp test = new _dp();
		String s = "babad";
	
		System.out.println(test.longestPalindrome(s));
	}
}
