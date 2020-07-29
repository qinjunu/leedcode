import java.util.Arrays;

public class _322_coinChange {

    public int coinChange(int[] coins, int amount) {

    	int[] dp = new int[amount+1];
    	int max = amount + 1;
    	Arrays.fill(dp, max);
    	dp[0] = 0;
    	
    	for(int i = 1; i <= amount; i++) {
    		for(int j = 0; j < coins.length; j++) {
    			if(i >= coins[j]) {
    				dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
    			}
    		}
    	}
    	
    	System.out.println(Arrays.toString(dp));
    	return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
    	_322_coinChange test = new _322_coinChange();
    	int[] coins = {2,5,10,1};
    	System.out.println(test.coinChange(coins, 27));
	}
}
