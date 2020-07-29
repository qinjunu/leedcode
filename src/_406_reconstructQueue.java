import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _406_reconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

    	//≈≈–Ú
    	Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
    		
    	});
    	
    	List<int[]> list = new LinkedList<>();
    	for(int[] p : people) {
    		list.add(p[1], p);
    	}
    	
    	return list.toArray(new int[people.length][2]);
    }
}
