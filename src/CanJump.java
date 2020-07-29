enum Status{
	Good,Bad,Unknown
}
public class CanJump {
	Status[] demo;
	//回溯算法 超时
	public boolean backtrack(int pos, int[] nums) {
		if(pos == nums.length-1) {
			return true;
		}
		int maxJump = Math.min(pos+nums[pos], nums.length-1);

		for(int i=pos+1; i<=maxJump; i++) {
			if(backtrack(i, nums)) {
				return true;
			}
		}
		return false;
	}
	public boolean canJump(int[] nums) {
		return backtrack(0, nums);
    }
	
	//自顶向下的动态规划
	public boolean backtrack1(int pos, int[] nums) {
		if(demo[pos] != Status.Unknown) {
			return demo[pos] == Status.Good ? true : false;
		}
		
		int maxJump = Math.min(pos+nums[pos], nums.length-1);

		for(int i=pos+1; i<=maxJump; i++) {
			if(backtrack1(i, nums)) {
				demo[i] = Status.Good;
				return true;
			}
		}
		demo[pos] = Status.Bad;
		return false;
	}

	public boolean canJump1(int[] nums) {
		demo = new Status[nums.length];
		for (int i = 0; i < demo.length; i++) {
			demo[i] = Status.Unknown;
		}
		demo[nums.length-1] = Status.Good;
		return backtrack1(0, nums);
    }
	//自底向上的动态优化
	public boolean canJump2(int[] nums) {
		demo = new Status[nums.length];
		for (int i = 0; i < demo.length; i++) {
			demo[i] = Status.Unknown;
		}
		demo[nums.length-1] = Status.Good;
		
		for(int i=nums.length-2; i>=0; i--) {
			int maxJump = Math.min(i+nums[i], nums.length-1);
			for(int j=i+1; j<=maxJump; j++) {
				if(demo[j] == Status.Good) {
					demo[i] = Status.Good;
					break;
				}
			}
		}
		
		return demo[0] == Status.Good;
    }
	
	//贪心算法
	public boolean canJump3(int[] nums) {
		int last = nums.length-1;
		for(int i=nums.length-2; i>=0; i--) {
			if(nums[i]+i >= last) {
				last = i;
			}
		}
		return last == 0;
	}
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		CanJump cj = new CanJump();
		System.out.println(cj.canJump(nums));
		System.out.println(cj.canJump1(nums));
		System.out.println(cj.canJump2(nums));
		System.out.println(cj.canJump3(nums));
	}
}
