
public class _338_countBits {

	/*
	 * 	 ʮ���� / 2 = �������Ƴ�ĩλ
	 *   dp[i] = dp[i/2] + i%2
	 * */
	public int[] countBits(int num){
		
		int[] dp = new int[num+1];
		
		for(int i = 1; i < num+1; i++) {
			dp[i] = dp[i/2] + i%2;
		}
		
		return dp;
	}
}
