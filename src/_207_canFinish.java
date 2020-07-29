import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_canFinish {
	//����
    public boolean canFinish(int numCourses, int[][] prerequisites) {

    	//��¼ÿ���ڵ�����
    	int[] indegree = new int[numCourses];
    	//���ڽӱ��ʾ
    	List<List<Integer>> adjacency = new ArrayList<>();
    	for(int i = 0; i < numCourses; i++) {
    		adjacency.add(new ArrayList<>());
    	}
    	for(int[] num : prerequisites) {
    		indegree[num[0]]++;
    		adjacency.get(num[1]).add(num[0]);
    	}

    	//�洢���Ϊ0�Ľڵ�
    	Queue<Integer> queue = new LinkedList<>();
    	for(int j = 0; j < numCourses; j++) {
    		if(indegree[j] == 0) {
    			queue.add(j);
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		numCourses--;
    		for(int a : adjacency.get(temp)) {
    			indegree[a]--;
    			if(indegree[a] == 0) {
    				queue.add(a);
    			}
    		}
    	}
    	return numCourses == 0;
    }
    //DFS
    public boolean DFS(List<List<Integer>> adjacency, int[] status, int point) {
    	if(status[point] == -1) {
    		return true;
    	}
    	if(status[point] == 1) {
    		return false;
    	}
    	status[point] = 1;
    	for(int a : adjacency.get(point)) {
    		if(!DFS(adjacency, status, a)) return false;
    	}
    	status[point] = -1;
    	return true;
    }
    
    
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
    	
    	//��¼ÿ���ڵ��״̬ 0 δ���� ; 1 �����ѷ���; -1 �ѱ�����·�����ʹ� 
    	int[] status = new int[numCourses];
    	//���ڽӱ��ʾ
    	List<List<Integer>> adjacency = new ArrayList<>();
    	for(int i = 0; i < numCourses; i++) {
    		adjacency.add(new ArrayList<>());
    	}
    	for(int[] num : prerequisites) {
    		adjacency.get(num[1]).add(num[0]);
    	}
    	
    	for(int i = 0; i < numCourses; i++) {
    		if(!DFS(adjacency, status, i)) {
    			return false;
    		}
    	}
    	return true;
    }
}
