import java.util.Arrays;

public class _279_numSquares {
	/*
	 *    ¶¯Ì¬¹æ»®
	 * */
    public int numSquares(int n) {

    	int[] dp = new int[n+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	
    	int maxSquare = (int)Math.sqrt(n);
    	
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= maxSquare; j++) {
    			if(i < j*j) {
    				break;
    			}
    			dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
    		}
    	}
//    	System.out.println(Arrays.toString(dp));
    	return dp[n];
    }
    public static void main(String[] args) {
    	_279_numSquares test = new _279_numSquares();
		System.out.println(test.numSquares(12));
	}
}
