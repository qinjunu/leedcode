
public class _148_sortList {
	
	// 链表合并
	public ListNode merge(ListNode p1, ListNode p2) {
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				temp.next = p1;
				p1 = p1.next;
			}else {
				temp.next = p2;
				p2 = p2.next;
			}
			temp = temp.next;
		}
		temp.next = p1 == null ? p2 : p1;
		return head.next;
	}
	
	// 归并(递归)
    public ListNode sortList(ListNode head) {

    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	// 寻找中心，划分为两份
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode center = slow.next;
    	slow.next = null;
    	// 递归
    	ListNode left = sortList(head);
    	ListNode right = sortList(center);
    	
    	// 合并
    	return merge(left, right);
    }

	/*
	 * 迭代：双重循环 
	 * 	第一层：控制回归个数 1 ，2 ， 4 ...
	 * 	第二层：每隔 k 个数合并 
	 */    
    public ListNode sortList1(ListNode head) {
    	
    	return null;
    }
    public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		_148_sortList test = new _148_sortList();
		ListNode head = test.sortList(n1);
		for(int i=0; i<4; i++) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
