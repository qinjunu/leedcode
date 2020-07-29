import java.util.Stack;

public class _394_decodeString {
	
    public String decodeString(String s) {

    	int mul = 0;
    	StringBuilder res = new StringBuilder();
    	
    	//借助两个栈保存倍数 multi    字符 res
    	Stack<Integer> stack_mul = new Stack<>();
    	Stack<String> stack_res = new Stack<>();

    	for(char c : s.toCharArray()) {
    		if(c >= '0' && c < '9') {
    			mul = mul * 10 + (c - '0');
    		}else if(c == '[') {
    			stack_mul.add(mul);
    			stack_res.add(res.toString());
    			mul = 0;
    			res = new StringBuilder();
    		}else if(c == ']') {
    			int temp_mul = stack_mul.pop();
    			StringBuilder mul_str = new StringBuilder();
    			for(int i = 0; i < temp_mul; i++) {
    				mul_str.append(res);
    			}
    			res = new StringBuilder(stack_res.pop() + mul_str);
    		}else {
    			res.append(c);
    		}
    	}
    	
    	
    	return res.toString();
    }

}
