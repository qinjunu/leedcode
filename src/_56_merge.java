import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_merge {

    public int[][] merge(int[][] intervals) {
    	if(intervals.length == 0) {
    		return new int[0][];
    	}
    	List<int[]> list = new ArrayList<>();
    	
    	int[] merge = new int[2];
    	
    	Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
    	});
    	merge = intervals[0];
    	for(int i = 1; i < intervals.length; i++) {
    		if(intervals[i][0] <= merge[1]) {
    			merge[1] = Math.max(intervals[i][1], merge[1]);
    			
    		}else {
    			System.out.println(Arrays.toString(merge));
    			list.add(merge);
    			merge = intervals[i];

    		}
    	}
    	list.add(merge);
    	int[][] ans = new int[list.size()][2];
    	for(int i = 0; i < list.size(); i++) {
    		ans[i] = list.get(i);
    	}
    	
    	return ans;
    }
    public static void main(String[] args) {
    	_56_merge test = new _56_merge();
    	int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

    	test.merge(intervals);
	}
}
