import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _347_topKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {

    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	//记录每个数出现的个数
    	for(int num : nums) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	//借助PriorityQueue
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
    			new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return map.get(o1) - map.get(o2);
					}
    				
    			});
    	
    	for(int n : map.keySet()) {
    		queue.offer(n);
    		if(queue.size() > k) {
    			queue.poll();
    		}
    	}
    	
    	List<Integer> top_k = new LinkedList<>();
    	while(!queue.isEmpty()) {
    		top_k.add(queue.poll());
    	}
    	Collections.reverse(top_k);
    	
    	return top_k;
    }
}
