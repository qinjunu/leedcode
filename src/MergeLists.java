
public class MergeLists {
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), p = ans;
    	while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		p.next = l1;
        		l1 = l1.next;
        	}else {
        		p.next = l2;
        		l2 = l2.next;
        	}
        	p = p.next;
    	}
    	if(l1 == null) {
    		p.next = l2;
    	}
    	if(l2 == null) {
    		p.next = l1;
    	}
    	
    	return ans.next;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = new ListNode(3);
		l1.next.next = null;
		l2.next = null;
		l1.output();
		l2.output();
		mergeTwoLists(l1,l2).output();
	}

}
