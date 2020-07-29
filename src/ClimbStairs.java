
public class ClimbStairs {
	// d[i] = d[i-1] + d[i-2] 
    public int climbStairs(int n) {
    	if(n == 1) return 1;
    	int[] dp = new int[n];
    	dp[0] = 1;
    	dp[1] = 2;
    	for(int i = 2; i < n; i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[n-1];
    }
    public static void main(String[] args) {
		ClimbStairs c = new ClimbStairs();
		System.out.println(c.climbStairs(3));
	}
}
