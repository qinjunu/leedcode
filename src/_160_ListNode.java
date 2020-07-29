
public class _160_ListNode {

	/*
	 * A �ߵ��յ� �� B ������B �ߵ��յ� �� A ����
	 * �����ٶ�һ�£�·��һ�£�����ཻ����ͬһʱ�䵽���յ㣬���ཻ��·����A Bһ���߹���
	 * A:a + c  B:b+c
	 * �ཻ��a + c + b + c = b + c + a + c 
	 * ���ཻ��a + b = b + c ����ߵ��Է���ĩβ.next null
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
