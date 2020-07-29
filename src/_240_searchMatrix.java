
public class _240_searchMatrix {

	/*
	 * 从最左下角开始寻找
	 * 
	 * */
    public boolean searchMatrix(int[][] matrix, int target) {
        
    	int row = matrix.length - 1;
    	int col = 0;
    	while(row >= 0 && col < matrix[0].length) {
    		if(matrix[row][col] == target) {
    			return true;
    		}else if(matrix[row][col] > target) {
    			row--;
    		}else {
    			col++;
    		}
    	}
    	
    	return false;
    }
    
}
