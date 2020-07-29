package collection;

import java.util.Comparator;

public class Test<T> implements Comparator<T>{

	public static void main(String[] args) {

		Customer1 c1 = new Customer1("aaa", 11);
		Customer1 c2 = new Customer1("aaa", 11);
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
