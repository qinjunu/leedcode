
public class _42_trap {

	// ±¸ÍüÂ¼
    public int trap(int[] height) {

    	if(height.length == 0) {
    		return 0;
    	}
    	
    	int ans = 0;
    	int n = height.length;
    	
    	int[] l_max = new int[n];
    	int[] r_max = new int[n];
    	
    	l_max[0] = height[0];
    	r_max[n-1] = height[n-1];
    	
    	for(int i = 1; i < n - 1; i++) {
    		l_max[i] = Math.max(l_max[i-1], height[i]);
    	}
    	for(int j = n - 2; j > 0; j--) {
    		r_max[j] = Math.max(r_max[j+1], height[j]);
    	}
    	
    	for(int k = 1; k < n - 1; k++) {
    		ans += Math.min(l_max[k], r_max[k]) - height[k];
    	}
    	
    	return ans;
    }
    // Ë«Ö¸Õë
    public int trap1(int[] height) {
    	if(height.length == 0) {
    		return 0;
    	}
    	int ans = 0;
    	int n = height.length;
    	
    	int l_max = height[0];
    	int r_max = height[n-1];
    	
    	int left = 0, right = n - 1;
    	
    	while(left < right) {
    		
    		l_max = Math.max(l_max, height[left]);
    		r_max = Math.max(r_max, height[right]);
    		
    		if(l_max < r_max) {
    			ans += l_max - height[left];
    			left++;
    		}else {
    			ans += r_max - height[right];
    			right--;
    		}
    		
    	}
    	
    	return ans;
    	
    }
}
