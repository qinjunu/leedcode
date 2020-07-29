import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class IntervalComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval a, Interval b) {
		//return (x < y) ? -1 : ((x == y) ? 0 : 1);
		return Integer.compare(a.start, b.start);
	}
	
}
public class Test {
	public static void main(String[] args){
		List<Interval> i = new ArrayList<Interval>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Interval(new int[] {3,3}));
				add(new Interval(new int[] {2,3}));
			}
		};
		IntervalComparator ic = new IntervalComparator();
		
		System.out.println(ic.compare(i.get(0), i.get(1)));
		
		Collections.sort(i, ic);
		System.out.println(i);
	}
}
