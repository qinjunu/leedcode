
public class _206_reverseList {
	
    public ListNode reverseList(ListNode head) {

    	if(head == null) {
    		return null;
    	}else if(head.next == null) {
    		return head;
    	}
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	p1.next = null;
    	while(p2 != null) {
    		ListNode temp = p2.next;
    		p2.next = p1;
    		p1 = p2;
    		p2 = temp;
    	}
    	
    	return p1;
    }
    public ListNode reverseList1(ListNode head) {
    	
    	ListNode newHead = null;
    	ListNode p1 = head, p2 = head;
    	while(p1 != null) {
    		p2 = p1.next;
    		p1.next = newHead;
    		newHead = p1;
    		p1 = p2;
    	}
    	return newHead;
    }
    public static void main(String[] args) {
    	
    	_206_reverseList test = new _206_reverseList();
    	
    	ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		n1.output();
		test.reverseList(n1).output();
	}
}
