import java.util.Arrays;
import java.util.Stack;

public class _581_findUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {

    	int[] temp = nums.clone();
    	Arrays.sort(nums);
    	
    	System.out.println(Arrays.toString(nums));
    	System.out.println(Arrays.toString(temp));
    	int start = nums.length;
    	int end = 0;
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] != temp[i]) {
    			start = Math.min(start, i);
    			end = Math.max(end, i);
    		}
    	}
    	
    	return end - start >= 0 ? end - start + 1 : 0;
    }
    // ½èÖúÕ»
    public int findUnsortedSubarray1(int[] nums) {
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	int start = nums.length;
    	int end = 0;
    	
    	for(int i = 0; i < nums.length; i++) {
    		while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
    			start = Math.min(stack.pop(), start);
    		}
    		stack.push(i);
    	}
    	stack.clear();
    	
    	for(int j = nums.length-1; j >= 0; j--) {
    		while(!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
    			end = Math.max(stack.pop(), end);
    		}
    		stack.push(j);
    	}
    	
    	return end - start >= 0 ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
    	int[] nums = {2,6,4,8,10,9,15};
    	_581_findUnsortedSubarray test = new _581_findUnsortedSubarray();
    	System.out.println(test.findUnsortedSubarray(nums));
    }	
}
