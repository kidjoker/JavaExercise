package cn.kidjoker.JavaExercise.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class HashMapTest {
	
	@Test public void test() {
		Set<Object> set = new HashSet<>();
		set.add("123");
		set.add("456");
		set.add("789");
//		Map<String, Object> map = new HashMap<>(8,0.5f);
//		map.put("hello1", "world");
//		map.put("hello2", "world");
//		map.put("hello3", "world");
//		map.put("hello4", "world");
//		map.put("hello5", "world");
//		map.get("hello");
	}
	
	@Test public void test2() {
		Map<String, Object> map1 = new LinkedHashMap<>(8);
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
