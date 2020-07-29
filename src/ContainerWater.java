
public class ContainerWater {
	static int area(int i,int h1,int j,int h2) {
		int h = Math.min(h1, h2);
		return h * (j - i);
	}
	static public int maxArea(int[] height) {
        int ans = 0;
		for(int i=0; i<height.length-1; i++) {
			for(int j=i+1; j<height.length; j++) {
				ans = Math.max(ans, area(i,height[i],j,height[j]));
	
			}
		}
		
		return ans;
    }
	// ·½·¨¶ş
	static public int maxArea1(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int ans = 0;
		while(start < end) {
			ans = Math.max(ans, area(start,height[start],end,height[end]));
			
			if(height[start] < height[end])
				start++; 
			else
				end--;
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		System.out.println(maxArea1(height));
	}

}
