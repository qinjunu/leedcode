import java.util.Random;

public class _shuffle {

	public void shuffle(int[] nums) {
		
		for(int i = nums.length - 1; i >= 0; i++) {
			int rand = (int)Math.random() * (i + 1);
			int temp = nums[i];
			nums[i] = nums[rand];
			nums[rand] = temp;
		}
		
	}
	public static void main(String[] args) {
		
		int min = 6, max = 10;
		int res = (int)(Math.random() * (max - min + 1) + min);
		
		Random rand = new Random();
		int res1 = rand.nextInt(max - min + 1) + min;
		
		for(int i = 0; i < 10; i++) {
			res = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(res);
		}
		System.out.println("****************");
		for(int i = 0; i < 10; i++) {
			res1 = rand.nextInt(max - min + 1) + min;
			System.out.println(res1);
		}
			
	}
}
