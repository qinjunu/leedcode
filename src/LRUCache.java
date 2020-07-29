import java.util.HashMap;
import java.util.LinkedList;

// ˫������ڵ�
class DNode{
	int key, value;
	DNode prior, next;
	public DNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
// ˫��������
class DLinkList{
	private DNode head, tail;
	private int size;
	
	// ��ʼ�� ��β����ָ��
	public DLinkList() {
		head = new DNode(0, 0);
		tail = new DNode(0, 0);
		head.next = tail;
		tail.prior = head;
		size = 0;
	}
	
	public void addFirst(DNode node) {
		node.next = head.next;
		head.next.prior = node;
		head.next = node;
		node.prior = head;
		size++;
	}
	
	public void remove(DNode node) {
		node.prior.next = node.next;
		node.next.prior = node.prior;
		size--;
	}
	
	public DNode removeLast() {
		if(tail.prior == head) {
			return null;
		}
		DNode last = tail.prior;
		remove(last);
		return last;
	}
	
	public int size() {
		return size;
	}
}
public class LRUCache {

	private HashMap<Integer, DNode> map;
	private DLinkList cache;
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		cache = new DLinkList();
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		int val = map.get(key).value;
		put(key, val);
		return val;
	}
	
	public void put(int key, int val) {
		DNode node = new DNode(key, val);
		if(map.containsKey(key)) {
			// ɾ���ɵĽڵ� ����µ���ͷ��
			cache.remove(map.get(key));
			cache.addFirst(node);
			// ���� map
			map.put(key, node);
		}else {
			if(cache.size() == capacity) {
				// ɾ�����һ���ڵ�
				DNode last = cache.removeLast();
				map.remove(last.key);
			}
			// �����ͷ��
			cache.addFirst(node);
			map.put(key, node);
		}
	}
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.addFirst(1);
		l.addLast(2);
		l.removeFirst();
		l.removeLast();
		LRUCache test = new LRUCache(2);
		test.put(1, 1);
	}
}
