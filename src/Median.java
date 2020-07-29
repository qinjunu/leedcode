import java.util.Arrays;

public class Median {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[n+m];
        int i = 0, j = 0, k = 0;
        double ans;
        while(i<m || j<n) {
        	if(i == m) {
        		nums[k++] = nums2[j++];
        		continue;
        	}
        	if(j == n) {
        		nums[k++] = nums1[i++];
        		continue;
        	}
        	if(nums1[i] <= nums2[j]) {
        		nums[k++] = nums1[i++];
        	}else {
        		nums[k++] = nums2[j++];
        	}
        }
        System.out.println(Arrays.toString(nums));
    	if((m+n)%2 == 1) { 	
    		ans = nums[(m+n)/2];
    	}else {
    		ans = (nums[(m+n)/2 - 1] + nums[(m+n)/2])/2.0;
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		int[] nums1 = {1,2}; 
		int[] nums2 = {3,4};
		System.out.print(findMedianSortedArrays(nums1,nums2));
	}

}
