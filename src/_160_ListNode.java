
public class _160_ListNode {

	/*
	 * A 走到终点 从 B 继续，B 走到终点 从 A 继续
	 * 两人速度一致，路程一致，如果相交会在同一时间到达终点，而相交的路程是A B一起走过的
	 * A:a + c  B:b+c
	 * 相交：a + c + b + c = b + c + a + c 
	 * 不相交：a + b = b + c 最后走到对方的末尾.next null
	 * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode p1 = headA;
    	ListNode p2 = headB;
    	
    	if(p1 == null || p2 == null) {
    		return null;
    	}
    	while(p1 != p2) {
    		p1 = p1 == null ? headB : p1.next;
    		p2 = p2 == null ? headA : p2.next;
    	}
    	
        return p1;
    }
}
