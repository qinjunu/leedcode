
public class Rotate {
	
	public void rotate(int[][] matrix) {
        int n = matrix.length;
		for(int i=0; i<n/2; i++) {
			for(int j=i; j<n-1-i; j++) {
				int temp = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Rotate test = new Rotate();
		test.rotate(matrix);
		System.out.println(matrix[0][0]);
	}
}
