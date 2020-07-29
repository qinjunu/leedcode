import java.util.HashSet;
import java.util.Set;

public class _141_hasCycle {
    public boolean hasCycle(ListNode head) {
    	
    	Set<ListNode> set = new HashSet<ListNode>();
    	while(head != null) {
    		if(set.contains(head)) {
    			return true;
    		}else {
    			set.add(head);
    		}
    		head = head.next;
    	}
    	
    	return false;
        
    }
    public boolean hasCycle1(ListNode head) {
    	
    	if(head == null || head.next == null) {
    		return false;
    	}
    	
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	while(p1 != p2) {
    		if(p2 == null || p2.next == null) {
    			return false;
    		}
    		p1 = p1.next;
    		p2 = p2.next.next;
    	}
    	return true;
    }
}
