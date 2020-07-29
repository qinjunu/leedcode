import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _969_pancakeSort {

	List<Integer> ans = new ArrayList<>();
	
    public List<Integer> pancakeSort(int[] A) {
    	
    	sort(A, A.length-1);
    	return ans;
    }
    public void sort(int[] cakes, int n) {
    	
    	if(n == 0) {
    		return;
    	}
    	// 寻找前n个数最大值
    	int maxInd = 0;
    	for(int i = 0; i <= n; i++) {
    		if(cakes[maxInd] < cakes[i]) {
    			maxInd = i;
    		}
    	}
    	System.out.println(maxInd);
    	ans.add(maxInd + 1);
    	// 移动最大至底
    	reverse(cakes, maxInd);
    	System.out.println(Arrays.toString(cakes));
    	
    	reverse(cakes, n);
    	System.out.println(Arrays.toString(cakes));
    	ans.add(n + 1);
    	sort(cakes, n-1);
    	
    }
    public void reverse(int[] nums, int end) {
    	for(int i = 0, j = end; i <= j; i++, j--) {
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    	}
    }
    public static void main(String[] args) {
    	_969_pancakeSort test = new _969_pancakeSort();
    	int[] A = {3,2,4,1};
    	System.out.println(test.pancakeSort(A));
	}
}
