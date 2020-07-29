import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _986_intervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

    	List<int[]> list = new ArrayList<>();
    	
    	int n1 = A.length;
    	int n2 = B.length;
    	int i = 0, j = 0;
    	
    	
    	
    	while(i < n1 && j < n2) {
    		int[] temp = new int[2]; 
    		System.out.println(i + " " + j);
    		if(A[i][1] >= B[j][0] && B[j][1] >= A[i][0]) {
    			temp[0] = Math.max(A[i][0], B[j][0]);
    			temp[1] = Math.min(A[i][1], B[j][1]);
    			System.out.println(Arrays.toString(temp));
    			list.add(temp);
    		}
    		
    		if (A[i][1] > B[j][1]) {
    			j++;
    		}
			else if(A[i][1] < B[j][1]) {
				i++;
			}
			else {
				i++;
				j++;
			}
    	}
    	int[][] ans = new int[list.size()][2];
    	for(int k = 0; k < list.size(); k++) {
    		System.out.println(Arrays.toString(list.get(k)));
    		ans[k] = list.get(k);
    	}
    	return ans;
    }
    public static void main(String[] args) {
    	_986_intervalIntersection test = new _986_intervalIntersection();
    	int[][] A = {{0,2},{5,10},{13,23},{24,25}};
    	int[][] B = {{1,5},{8,12},{15,24},{25,26}};
    	test.intervalIntersection(A, B);
	}
}
