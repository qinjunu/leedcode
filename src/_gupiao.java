import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * -今天我没有持有股票 有两种可能 
 *       1. 昨天没有持有 选择rest
 *       2. 昨天持有 今天sell 
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * -今天我持有股票 有两种可能
 *       1. 昨天持有 选择rest
 *       2. 昨天没有持有 选择buy
 **/
public class _gupiao {

	/*
	 * 121 允许一次交易
	 * */
	public int maxProfit_k_1(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		//0 1 表示不持有 持有两个状态
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		
		return dp_i_0;
	}
	
	/*
	 * 122 不限制次数
	 * */
	public int maxProfit_k_inf(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		
		return dp_i_0;
	}
	
	/*
	 * 123 最多允许两次交易
	 *     今天 第二次交易 - 购买   在昨天 第一次交易 - 出售  的基础上更新
	 * */
	public int maxProfit_k_2(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		int dp_i_2_0 = 0;
		int dp_i_2_1 = -prices[0];

		int dp_i_1_0 = 0;
		int dp_i_1_1 = -prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
			dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
			dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
			dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
		}
		
		return dp_i_2_0;
	}
	
	/*
	 * 188 最多允许k次交易
	 * */
	public int maxProfit_k_k(int k, int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		if(k > prices.length/2) {
			return maxProfit_k_inf(prices);
		}
		
		int[][][] dp = new int[prices.length][k+1][2];
		
		for(int i = 1; i <= k; i++) {
			dp[0][i][0] = 0;
			dp[0][i][1] = -prices[0];
		}
	
		for(int i = 1; i < prices.length; i++) {
			for(int j = k; j > 0; j--) {
				dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
			}
		}
		return dp[prices.length-1][k][0];
	}
	
	/*
	 * 309 不限制次数  加入冷冻期一天
	 * */
	public int maxProfit_k_inf_cool(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		//dp[i-2][0]
		int dp_pre_0 = 0;
		
		for(int i = 1; i < prices.length; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		
		return dp_i_0;
	}
	
	/*
	 * 714 不限制次数  加入手续费
	 * */
	public int maxProfit_k_inf_fee(int[] prices, int fee) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		int dp_i_0 = 0, dp_i_1 = -prices[0] - fee;
		
		for(int i = 1; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - fee - prices[i]);
		}
		
		return dp_i_0;
	}
	public static void main(String[] args) {
		_gupiao test = new _gupiao();
		int[] prices = {7,1,5,3,6,8};
		System.out.println(test.maxProfit_k_k(1, prices));
	}
}
