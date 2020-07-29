
class Pair{
	// 先手和后手
	int fir;
	int sec;
	public Pair() {}
	public Pair(int fir, int sec) {
		this.fir = fir;
		this.sec = sec;
	}
}
public class _dp_game {

	public int stoneGame(int[] piles){
		
		Pair[][] dp = new Pair[piles.length][piles.length];

		for(int i = 0; i < piles.length; i++) {
			for(int j = i; j < piles.length; j++) { 
				dp[i][j] = new Pair(0, 0);
			}
		}
		
		for(int len = 0; len < piles.length; len++) {
			for(int i = 0; i < piles.length - len; i++) {
				int j = i + len;
				if(len == 0) {
					dp[i][j].fir = piles[i];
					dp[i][j].sec = 0;
				}else { 
					int left = piles[i] + dp[i+1][j].sec;
					int right = piles[j] + dp[i][j-1].sec;
					if(left > right) {
						dp[i][j].fir = left;
						dp[i][j].sec = dp[i+1][j].fir;
					}else {
						dp[i][j].fir = right;
						dp[i][j].sec = dp[i][j-1].fir;
					}
					
				}
			}
		}
		return dp[0][piles.length-1].fir - dp[0][piles.length-1].sec;
	}
	public static void main(String[] args) {
		_dp_game test = new _dp_game();
		int[] array = {1, 10, 2, 5};
		System.out.println(test.stoneGame(array));
		

	}
}
