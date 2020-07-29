
public class UniquePaths {
	//��̬�滮
	//m:����  n:����
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[n][m];
        //����һ�к͵�һ����Ϊ1
        for(int i=0; i<n; i++) ans[i][0] = 1;
        for(int i=0; i<m; i++) ans[0][i] = 1;
    	
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		ans[i][j] = ans[i-1][j] + ans[i][j-1];
        	}
        }
        return ans[n-1][m-1];
    }
    public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		
    	System.out.println(u.uniquePaths(7,3));
	}
}
