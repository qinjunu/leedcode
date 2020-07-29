
public class _37_solveSudoku {

	int n = 9;
    public void solveSudoku(char[][] board) {

    	backtrack(board, 0, 0);
    	
    }

    // 返回 boolean 在找到第一个答案时 程序终止
    public boolean backtrack(char[][] board, int row, int col) {
    	
    	if(row == n) {
    		return true;
    	}
    	
    	if(col == n) {
    		return backtrack(board, row + 1, 0);
    	}
    	
    	if(board[row][col] != '.') {
    		return backtrack(board, row, col + 1);
    	}
    	
    	for(char c = '1'; c <= '9'; c++) {
    		if(!isValid(board, row, col, c)) {
    			continue;
    		}
    		board[row][col] = c;
    		if(backtrack(board, row, col + 1)) {
    			return true;
    		}
    		
    		board[row][col] = '.';
    	}
    	
    	return false;
    }
    public boolean isValid(char[][] board, int row, int col, char c) {
    	
    	for(int i = 0; i < n; i++) {
    		if(board[i][col] == c) {
    			return false;
    		}
    		if(board[row][i] == c) {
    			return false;
    		}
    		if(board[row/3 * 3 + i / 3][col/3 * 3 + i % 3] == c) {
    			return false;
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			System.out.println(4/3 * 3 + i / 3 + " " + (4/3 * 3 + i % 3));
//			System.out.println(0/3 * 3 + i % 3);
		}
	}
}
