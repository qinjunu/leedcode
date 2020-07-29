import java.util.Arrays;
import java.util.Comparator;

public class _354_maxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

    	if(envelopes.length == 0) {
    		return 0;
    	}
    	
    	Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
    	
    	});
    	
    	int len = envelopes.length;
    	int[] dp = new int[len];
    	Arrays.fill(dp, 1);
    	
    	int max = 0;
    	
    	for(int i = 1; i < len; i++) {
    		for(int j = i - 1; j >= 0; j--) {
    			if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    			}
    		}
    		max = Math.max(max, dp[i]);
    	}
    	
    	return max;
    }
    
}
