
public class _461_hammingDistance {

    public int hammingDistance(int x, int y) {

    	int xor = x ^ y;
    	int ans = 0;
    	
    	while(xor != 0) {
    		if(xor % 2 == 1) {
    			ans++;
    		}
    		xor = xor >> 1;
    	}
    	
    	return ans;
    }
    public static void main(String[] args) {
		System.out.println(10 ^ 1);
		System.out.println(2 >> 1);
	}
}
