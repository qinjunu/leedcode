import java.util.Arrays;

class ListNode1{
	int val;
	ListNode1 next;
	ListNode1(int x){
		val = x;
	}
	public String toString() {
		return this.val + "" + this.next.val + "" + this.next.next.val;
		
	}
}
public class Add_two_num {
	
	static ListNode1 addTwoNumbers(ListNode1 l1,ListNode1 l2) {
		int temp = 0;
		ListNode1 Head = new ListNode1(0);
		ListNode1 cur = Head;
		ListNode1 p = l1;
		ListNode1 q = l2;
	
		while(p != null || q != null) {
			int num1 = (p !=null) ? p.val : 0;
			int num2 = (q !=null) ? q.val : 0;
//			l3.val = (num1 + num2 + temp) % 10;
			int sum = num1 + num2 + temp;
			cur.next = new ListNode1(sum % 10);
			temp = sum / 10;
			cur = cur.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(temp > 0) {
			cur.next = new ListNode1(temp);
		}
		return Head.next;
		
	}

	public static void main(String[] args) {
		ListNode1 l1 = new ListNode1(2);
		l1.next = new ListNode1(4);
		l1.next.next = new ListNode1(3);
		ListNode1 l2 = new ListNode1(5);
		l2.next = new ListNode1(6);
		l2.next.next = new ListNode1(4);
		System.out.println(addTwoNumbers(l1,l2));

	}

}
