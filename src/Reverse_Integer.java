
public class Reverse_Integer {
	static public int reverse(int x) {
	
		boolean is_fushu = false;
		if(x < 0) {
			is_fushu = true;
			x = -x;
		}
        long ans = 0;
        int index = 0;
        int x1 = x;
        while(x1 / 10 > 0) {
        	index++;
        	x1 /= 10;
        }
		while(x > 0) {
        	ans += (x % 10) * Math.pow(10, index--);
        	x /= 10;
        }
		
		if(is_fushu)	ans = -ans;
		
		if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)	ans = 0;
		int ans_int = (int)ans;
		return ans_int;
    }
	public static void main(String[] args) {
		int a = 1534236469;
		System.out.println(reverse(a));
		
	}

}
