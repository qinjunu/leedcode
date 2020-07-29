import java.util.LinkedList;
import java.util.Queue;

public class _200_numIslands {
	//DFS
	public void DFS(char[][] grid, int row, int col) {
		
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
				|| grid[row][col] == '0') {
			return ;
		}
		
		grid[row][col] = '0';
		DFS(grid, row-1, col);
		DFS(grid, row+1, col);
		DFS(grid, row, col-1);
		DFS(grid, row, col+1);
		
		
	}
    public int numIslands(char[][] grid) {
    	if(grid == null) {
    		return 0;
    	}
    	int num = 0;
    	for(int row=0; row<grid.length; row++) {
    		for(int col=0; col<grid[0].length; col++) {
    			
    			if(grid[row][col] == '1') {
    				num++;
    				DFS(grid, row, col);
    			}
    		}
    	}
    	return num;
    }
    //BFS
    public int numIslands1(char[][] grid) {
    	if(grid == null || grid.length == 0) {
    		return 0;
    	}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int num = 0;
    	int rlen = grid.length;
    	int clen = grid[0].length;
    	
    	for(int row = 0; row < rlen; row++) {
    		for(int col = 0; col < clen; col++) {
    			
    			if(grid[row][col] == '1') {
    				
//    				System.out.println(row + " " + col);
    				
    				queue.add(row * clen + col); 
    				grid[row][col] = '0';
    				num++;
    				
//    				System.out.println(num);
    				
    				while(!queue.isEmpty()) {
        				int temp = queue.remove();
        				int row1 = temp / clen;
        				int col1 = temp % clen;
        				
//        				System.out.println(row1 + " " + col1);
        				
        				if(row1-1 >= 0 && grid[row1-1][col1] == '1') {
        					queue.add((row1-1) * clen + col1);
        					grid[row1-1][col1] = '0';
        				}
        				
        				if(row1+1 < rlen && grid[row1+1][col1] == '1') {
        					queue.add((row1+1) * clen + col1);
        					grid[row1+1][col1] = '0';
        				}
        				if(col1-1 >= 0 && grid[row1][col1-1] == '1') {
        					queue.add(row1 * clen + col1-1);
        					grid[row1][col1-1] = '0';
        				}
        				
        				if(col1+1 < clen && grid[row1][col1+1] == '1') {
        					queue.add(row1 * clen + col1+1);
        					grid[row1][col1+1] = '0';
        				}
        			}
    			}
    			
    			
    		}
    	}
    	return num;
    }
    public static void main(String[] args) {
    	_200_numIslands test = new _200_numIslands();
    	char[][] grid = {{'1','1','1','1','0'},
    			{'1','1','0','1','0'},
    			{'1','1','0','0','0'},
    			{'0','0','0','0','0'}};
    	System.out.println(test.numIslands1(grid));
	}
}
