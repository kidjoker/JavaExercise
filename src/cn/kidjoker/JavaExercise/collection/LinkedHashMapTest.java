package cn.kidjoker.JavaExercise.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class LinkedHashMapTest {
	@Test public void test2() {
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put("qwe", 1);
		map1.put("132", 2);
		map1.put("erty", 3);
		System.out.println("插入有序");
		for(Entry<String, Object> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("###########################");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("qwe", 1);
		map2.put("132", 2);
		map2.put("erty", 3);
		System.out.println("插入无序");
		for(Entry<String, Object> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
