import java.util.Scanner;

public class ListNode {
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val){
		this.val = val;
	}
	public void output() {
		ListNode l = this;
		while(l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode l = new ListNode(), p = l;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			ListNode node = new ListNode(sc.nextInt());
			p.next = node;
			p = p.next;
		}
		p = null;
        l.next.output();
        sc.close();
	}
}
