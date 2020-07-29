
import java.util.Scanner;

class ListNode2{
	int val;
	ListNode2 next;
	ListNode2(){}
	ListNode2(int val){
		this.val = val;
	}
	public void output() {
		ListNode2 l = this;
		while(l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}

		
	}
}
public class RemoveNthFromEnd {
    static public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 list = new ListNode2(0);
        list.next = head;
    	ListNode2 p = list,q = list;
        int i = 0;
        while(q.next != null) {
        	if(i < n) {
        		q = q.next;
        		i++;
        	}else {
        		p = p.next;
        		q = q.next;
        	}
        }
        System.out.println("before_delete");
        list.output();
    	if(i == n) {
    		p.next = p.next.next;
    		//System.out.println("delete");
    	}
    	System.out.println("\nafter_delete");
    	list.output();
    	System.out.println("\nans");
    	return list.next;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListNode2 head = new ListNode2(),p = head;
		
//		System.out.println("test_start");
//		System.out.println(p);
//		System.out.println(head);
//		head.output();
//		p.next = new ListNode(5);
//		head.output();
//		System.out.println("test_end");
		
		
		while(sc.hasNextInt()) {
			ListNode2 node = new ListNode2(sc.nextInt());
			p.next = node;
			p = node;
		}
		head.output();
		p.next = null;
		//head.output();
		sc.close();
		System.out.println();
		removeNthFromEnd(head,1).output();
	}

}
