import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval{
	int start;
	int end;
	Interval(int[] interval){
		this.start = interval[0];
		this.end = interval[1];
	}
	public int[] toArray() {
		return new int[] {this.start, this.end};
	}
	@Override
	public String toString() {
		return "("+this.start+","+this.end+")";
	}
}
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervallist = new LinkedList<>();
        for(int[] interval : intervals) {
        	intervallist.add(new Interval(interval));
        }
        
        intervallist.sort(new Comparator<Interval>(){
        	@Override
        	public int compare(Interval a, Interval b) {
        		return Integer.compare(a.start, b.start);
        	}
        });
     
        LinkedList<Interval> merged = new LinkedList<>();
        for(Interval i : intervallist) {
        	if(merged.isEmpty() || merged.getLast().end<i.start) {
        		merged.addLast(i);
        	}else {
        		merged.getLast().end = Math.max(merged.getLast().end, i.end);
        	}
        }
        int i = 0;
        int[][] result = new int[merged.size()][2];
        for(Interval j : merged) {
        	result[i++] = j.toArray();
        }
    	
    	return result;
    }
    public static void main(String[] args) {
		Merge m = new Merge();
    	int[][] nums = {{1,4},{4,5},{6,7,7}};
    	System.out.println(nums.length);
    	System.out.println(Arrays.toString(nums[2]));
    	System.out.println(nums[1].length);
		//System.out.println(Arrays.toString(m.merge(nums)));
	}
}
