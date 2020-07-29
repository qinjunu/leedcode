import java.util.Arrays;

public class _221_maximalSquare {
    public int maximalSquare(char[][] matrix) {

    	if(matrix == null || matrix.length == 0) {
    		return 0;
    	}
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int[][] dp = new int[row][col];
    	int max = 0;
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(i == 0 || j == 0) {
    				dp[i][j] = matrix[i][j] - '0';
    				if(dp[i][j] == 1 && max == 0) max = 1;
    			}else {
    				if(matrix[i][j] == '1') {
        				dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
        				max = Math.max(dp[i][j], max);
    				}
    			}
    		}
    	}
  
    	System.out.println(Arrays.toString(dp[0]));
    	System.out.println(Arrays.toString(dp[1]));
    	System.out.println(Arrays.toString(dp[2]));
    	System.out.println(Arrays.toString(dp[3]));
    	return max * max;
    }
    public static void main(String[] args) {
    	_221_maximalSquare test = new _221_maximalSquare(); 
       	char[][] matrix = {{'1','0','1','0','0'},
    			{'1','0','1','1','1'},
    			{'1','1','1','1','1'},
    			{'1','0','0','1','0'}};
       	System.out.println(test.maximalSquare(matrix));
	}
}
