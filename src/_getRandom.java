import java.util.Random;

public class _getRandom {

	public int getRandom(ListNode head) {
		
		Random rand = new Random();
		
		ListNode p = head;
		int i = 0;
		int ans = 0;
		
		while(p != null) {
			// [0, i): 1 / i
			if(rand.nextInt(++i) == 0) {
				ans = p.val;
			}
			p = p.next;
		}
		
		return ans;
	}
	public int[] getKRandom(ListNode head, int k) {
		
		Random rand = new Random();
		
		ListNode p = head;
		int[] ans = new int[k];
		int i = 0;
		
		// 前 k 个元素先默认选上，后面更新
		for(; i < k && p != null; i++) {
			ans[i] = p.val;
			p = p.next;
		}
		
		// i = k
		while(p != null) {
			
			// 同时更新 ans[j] 的内容
			int j = rand.nextInt(++i);
			if(j < k) {
				ans[j] = p.val;
			}
			p = p.next;
		}
		
		return ans;
	}
	
}
