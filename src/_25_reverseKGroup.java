
public class _25_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

    	ListNode p1 = head, p2 = head;
    	
    	for(int i = 0; i < k; i++) {
    		if(p2 == null) return head;
    		p2 = p2.next;
    	}
    	
    	ListNode newHead = reverse(p1, p2);
    	
    	p1.next = reverseKGroup(p2, k);
    	
    	return newHead;
    }
    
    // [start, end)
    public ListNode reverse(ListNode start, ListNode end) {
    	
    	ListNode head = null;
    	ListNode p1 = start, p2 = start;
    	
    	while(p1 != end) {    	
    		p2 = p1.next;
    		p1.next = head;
    		head = p1;
    		p1 = p2;
    		
    	}
    	return head;
    }
    
}
