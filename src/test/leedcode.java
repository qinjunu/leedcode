package test;

import java.util.Hashtable;
import java.util.Map;

abstract class testAbstract{
	public void hello() {
		System.out.println("hello world");
	}
}

interface testInterface{
	int i = 0;
	 public static void hello() {
		System.out.println("hello world");
	}
}



public class leedcode {
 
    public static void main(String[] args) {
    	Map<Object, Object> map = new Hashtable<>();
    	map.put(1, 1);
    	
    }
}
