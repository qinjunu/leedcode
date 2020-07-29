
public class _234_isPalindrome {

	
    public boolean isPalindrome(ListNode head) {

    	if(head == null || head.next == null) {
    		return true;
    	}
    	
    	ListNode head1 = center(head);
    	head1 = reverseList(head1);
    	while(head1 != null) {
    		if(head1.val == head.val) {
    			head1 = head1.next;
    			head = head.next;
    		}else {
    			return false;
    		}
    	}
    	return true;
    }
    
    //Ñ°ÕÒÖÐÐÄµã
    public ListNode center(ListNode head) {

    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow.next;
    }
    
    // reverse
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
    
}
