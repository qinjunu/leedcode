package collection;

public class Customer1 implements Comparable{
	private String name;

    private int age;

    public Customer1(String name, int age) {
        this.age = age;
        this.name = name;
    }

	@Override
	public int compareTo(Object o) {

		Customer1 c = (Customer1)o;
		
		return this.age - c.age;
	}
	public static void main(String[] args) {

		Customer1 c1 = new Customer1("aaa", 11);
		Customer1 c2 = new Customer1("aaa", 12);
//		System.out.println(c1 == c2);
//		System.out.println(c1.equals(c2));
//		System.out.println(c1.hashCode());
//		System.out.println(c2.hashCode());
		System.out.println(c1.compareTo(c2));
	}

	
}
