import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *记录balance仅仅能解决单一括号的问题
 *对于多种括号采用栈 
 * */
class Stack1{
	List<Character> data;
	int top;
	public void InitStack() {
		this.data = new ArrayList<Character>();
		this.top = -1;
	}
	public boolean stackEmpty() {
		if(this.top == -1) 
			return true;
		else 
			return false;
	}
	public void push(char c) {
		this.data.add(c);
		top++;
	}
	public char pop() {
		char c = this.data.get(top);
		this.data.remove(top);
		top--;
		return c;
	}
	public char getTop() {
		char c = this.data.get(top);
		return c;
	}
}
public class ValidParentheses {
	static public boolean isValid(String s) {
        Stack1 stack = new Stack1();
        stack.InitStack();
        Map<Character, Character> map = new HashMap<Character, Character>(){
			private static final long serialVersionUID = 1L;
			{
        		put('(', ')');
        		put('[',']');
        		put('{','}');
        	}
        };
		for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(stack.stackEmpty())
        		stack.push(c);
        	else {
        		char top = stack.getTop();
        		char top_value = '/';
        		if(map.containsKey(top))	top_value = map.get(top);
        		if(c == top_value) {
        			stack.pop();
        		}else {
        			stack.push(c);
        		}
        	}
        }
		return stack.stackEmpty();
    }
	public static void main(String[] args) {
		System.out.println(isValid("()"));

	}

}
