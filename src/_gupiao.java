import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * -������û�г��й�Ʊ �����ֿ��� 
 *       1. ����û�г��� ѡ��rest
 *       2. ������� ����sell 
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * -�����ҳ��й�Ʊ �����ֿ���
 *       1. ������� ѡ��rest
 *       2. ����û�г��� ѡ��buy
 **/
public class _gupiao {

	/*
	 * 121 ����һ�ν���
	 * */
	public int maxProfit_k_1(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		//0 1 ��ʾ������ ��������״̬
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		
		return dp_i_0;
	}
	
	/*
	 * 122 �����ƴ���
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
	 * 123 ����������ν���
	 *     ���� �ڶ��ν��� - ����   ������ ��һ�ν��� - ����  �Ļ����ϸ���
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
	 * 188 �������k�ν���
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
	 * 309 �����ƴ���  �����䶳��һ��
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
	 * 714 �����ƴ���  ����������
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
