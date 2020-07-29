
public class Search {
	/**
	 *二分查找旋转位置
	 *特殊节点：首尾相连的地方
	 */
	
	static public int rotate(int[] nums) {
		int left = 0, right = nums.length - 1;
		if(nums[left] <= nums[right]) return 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			//System.out.println(nums[mid]);
			if(nums[mid] > nums[mid+1]) {
				return mid+1;
			}else {
				if(nums[mid] >= nums[left]) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return 0;
	}
	//二分查找
	static public int binarySearch(int[] nums, int left, int right, int target) {
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	
    static public int search(int[] nums, int target) {
    	if(nums.length == 0 || nums == null) return -1;
        int rotate = rotate(nums);
        int ans = -1;
        if(rotate == 0) {
        	ans = binarySearch(nums,0,nums.length-1,target);
        }else {
        	if(target >= nums[0])
        		ans = binarySearch(nums,0,rotate-1,target);
        	else
        		ans = binarySearch(nums,rotate,nums.length-1,target);
        }
    	return ans;
    }	
	public static void main(String[] args) {
		int[] nums = {};
		
		System.out.println(search(nums,4));
	}
}
