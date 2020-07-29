import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class _116_connect {
	
    public Node connect(Node root) {
    	if(root == null) {
    		return root;
    	}
    	
    	Queue<Node> queue = new LinkedList<>();
    	
    	Node node = root;
    	queue.add(node);
    	
    	while(!queue.isEmpty()) {
    		List<Node> level = new ArrayList<>();
    		int len = queue.size();
    		for(int i = 0; i < len; i++) {
    			node = queue.poll();
        		level.add(node);
        		if(node.left != null) {
        			queue.add(node.left);
        		}
        		if(node.right != null) {
        			queue.add(node.right);
        		}
    		}
    		for(int i = 0; i < level.size() - 1; i++) {
    			if(level.get(i + 1) != null) {
    				level.get(i).next = level.get(i + 1);
    			}else {
    				level.get(i).next = null;
    			}
    		}
    	}
    	return root;
    }
}
