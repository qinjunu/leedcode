package test;

public class Test {
	public static void main(String[] args) {
		People p1 = new People(20);
		People p2 = new People(20);
		People p3 = new People(30);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		try {
			Class person = Class.forName("test.Test");
			System.out.println(person);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
class People{
	int age;
	
	public People(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.age == ((People)obj).age;
	}
}