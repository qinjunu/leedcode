
public class Guess_Numbers {
	static public int game(int[] guess, int[] answer) {
        int n = guess.length;
        int ans = 0;
		for(int i=0; i<n; i++) {
			if(guess[i] == answer[i]) {
				ans++;
			}
		}
		
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
