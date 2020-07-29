import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_to_Integer {
	static public int myAtoi(String str) {
	
		int ans = 0;
        int i = 0;
        boolean start = false;
        int start_index = 0;
        int temp = 0;
        while(i < str.length()) {
        	char c = str.charAt(i);
        	// Character.isDigit(c)
        	if(c == ' ' && !start) {
				i++;
				start_index = i;
				continue;
			}
        	start = true;
        	//System.out.println(start_index);
        	if(!Character.isDigit(str.charAt(start_index)) && 
					str.charAt(start_index) != '+' && 
					str.charAt(start_index) != '-') {
        		break;
        	}	
        	if(c == '+' || c == '-'){
        		if(i+1 != str.length())
        			if(!Character.isDigit(str.charAt(i+1)))	return 0;
        		i++;
   
        		continue;
        	}
    		if(str.charAt(start_index) == '-') {
    			temp = -(c-'0');
    		}else {
        		temp = c-'0';
        	}
    		if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && temp > 7)) {
    			return Integer.MAX_VALUE;
    		}
    		if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && temp < -8)) {
    			return Integer.MIN_VALUE;
    		}
    		ans = ans*10 + temp;
        	
    		if(i+1 != str.length()) {
	        	if(!Character.isDigit(str.charAt(i+1))) {	 
	        		break;
	        	}
        	}
	        i++;
        } 
		return ans;
    }
	
	// 正则表达式
	static public int myAtoi1(String str) {
		int ans = 0;
		
		str = str.trim();
		
		String regex = "[-|+]?\\d++";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if(m.lookingAt()) {
			try {
				ans = Integer.valueOf(m.group());
			} catch (Exception e) {
				ans = str.charAt(0) == '-' ? Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		
//		System.out.println(Integer.parseInt(String.valueOf('1')));
//		System.out.println(Integer.parseInt("123"));
		String str = "-465555555555555555554654";
//		System.out.println(str.isEmpty());
		System.out.println(myAtoi(str));
		System.out.println(myAtoi1(str));
	}

}
