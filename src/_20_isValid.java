import java.util.HashMap;
import java.util.Stack;

public class _20_isValid {

	public boolean isValid(String s) {
		
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				stack.add(c);
			}else {
				if(!stack.isEmpty() && c == map.get(stack.peek())) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}
