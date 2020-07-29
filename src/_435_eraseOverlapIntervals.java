import java.util.Arrays;
import java.util.Comparator;

public class _435_eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

    	if(intervals.length == 0) {
    		return 0;
    	}
    	Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
    	
    	int count = 1;
    	int minend = intervals[0][1];
    	
    	for(int[] interval : intervals) {
    		if(interval[0] >= minend) {
    			count++;
    			System.out.println(minend);
    			minend = interval[1];
    			System.out.println(minend);
    		}
    	}
    	
    	return intervals.length - count;
    }
    public static void main(String[] args) {
    	_435_eraseOverlapIntervals test = new _435_eraseOverlapIntervals();
    	int[][] intervals = {{1,3},{2,6},{8,10},{5,18}};
    	System.out.println(test.eraseOverlapIntervals(intervals));
	}
}
