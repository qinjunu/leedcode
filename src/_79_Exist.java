//µ¥´ÊËÑË÷
public class _79_Exist {
    
	char[][] board;
	String word;
	int m;
	int n;
	int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
	boolean[][] mark;
	public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
		this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        mark = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(dfs(i,j,0)) {
        			return true;
        		}
        	}
        }
    	return false;
    }
    public boolean dfs(int i, int j, int start) {
    	if(start == word.length()-1) {
    		return board[i][j] == word.charAt(start);
    	}
    	if(board[i][j] == word.charAt(start)) {
    		mark[i][j] = true;
    		for(int k=0; k<4; k++) {
    			int newI = i + direction[k][0];
    			int newJ = j + direction[k][1];
    			if(crossBorder(newI, newJ) && !mark[newI][newJ]) {
    				if(dfs(newI,newJ,start+1)) {
    					return true;
    				}
    			}
    		}
    		mark[i][j] = false;
    	}
    	return false;
    }
    public boolean crossBorder(int i, int j){
    	return i>=0 && i<m && j>=0 && j<n;
    }
    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String word = "ab";
        _79_Exist solution = new _79_Exist();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);

	}
}
