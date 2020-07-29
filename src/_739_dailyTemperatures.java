import java.util.Arrays;
import java.util.Stack;

public class _739_dailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
    	
    	if(T == null || T.length == 0) {
    		return null;
    	}

    	int[] ans = new int[T.length];
    	for(int i = 0; i < T.length; i++) {
    		int num = 0;
    		for(int j = i; j < T.length-1; j++) {
    			if(T[j+1] <= T[i]) {
    				num++;
    			}else {
    				ans[i] = ++num;
    				break;
    			}
    		}
    		
    	}
    	return ans;
    }
    
    public int[] dailyTemperatures1(int[] T) {
    	
    	if(T == null || T.length == 0) {
    		return null;
    	}

    	int[] ans = new int[T.length];
    	Stack<Integer> stack = new Stack<>();
    	
    	for (int i = T.length - 1; i >= 0; --i) {
    		while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
    			stack.pop();
    		}
    		ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
    		
    	}
    	
    	return ans;
    }
    public static void main(String[] args) {
    	_739_dailyTemperatures test = new _739_dailyTemperatures();
    	int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
    	System.out.println(Arrays.toString(test.dailyTemperatures(nums)));
	}
}
