package test;

class Parent{
	static void test() {
		System.out.println("parent");
	}
}
class Child extends Parent{
	void test1() {
		System.out.println();
	}
}

public class Testextend {

	Child c = new Child();
	
	
}
