package test;

import java.util.HashMap;
import java.util.Map;

public class Test_getOrDefault {
	public static void main(String[] args) {
		Map<String, Object> hashmap = new HashMap<>();
		hashmap.put("q", 123);
		hashmap.put("w", null);
		System.out.println(hashmap.keySet());
		System.out.println(hashmap.getOrDefault("o",666));
	
		
	}
}
