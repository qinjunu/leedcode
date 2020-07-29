import java.util.HashSet;
import java.util.Set;

public class _142_detectCycle {
    
	public ListNode detectCycle(ListNode head) {
    	
    	Set<ListNode> set = new HashSet<ListNode>();
    	while(head != null) {
    		if(set.contains(head)) {
    			return head;
    		}else {
    			set.add(head);
    		}
    		head = head.next;
    	}
    	
    	return null;
        
    }
	public ListNode detectCycle1(ListNode head) {
    	
    	if(head == null || head.next == null) {
    		return null;
    	}
    	
    	ListNode p1 = head;
    	ListNode p2 = head;
    	
    	while(p2 != null && p2.next != null) {
    		p1 = p1.next;
    		p2 = p2.next.next;
    		if(p1 == p2 ) break;
		}
   
    	if(p2 == null || p2.next == null) {
    		return null;
    	}

    	p1 = head;
    	while(p1 != p2) {
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return p1;
    }
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		_142_detectCycle test = new _142_detectCycle();
		
//		System.out.println(test.detectCycle(node1).val);
		System.out.println(test.detectCycle1(node1));
		
	}
}
