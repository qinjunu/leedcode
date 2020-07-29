package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCollection {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		System.out.println(list.contains(1));
		System.out.println(list.toArray());
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 10);
		map.put(2, 10);
		map.put(3, null);
		System.out.println(map);
	}
}
