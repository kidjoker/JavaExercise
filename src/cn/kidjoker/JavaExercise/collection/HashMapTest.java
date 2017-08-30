package cn.kidjoker.JavaExercise.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class HashMapTest {
	
	@Test public void test() {
		Map<String, Object> map = new HashMap<>(8,0.9f);
		map.put("hello1", "world");
		map.put("hello2", "world");
		map.put("hello3", "world");
		map.put("hello4", "world");
		map.put("hello5", "world");
		map.get("hello");
		
		map.put(null, 1);
		System.out.println(map.get(null));
		
		Set<Entry<String, Object>> sEntries = map.entrySet();
		for (Entry<String, Object> entry : sEntries) {
			if(entry.getKey().equals("hello4")) {
				System.out.println((3 ^ entry.getKey().hashCode()) % 7);
			}
			if(entry.getKey().equals(null)) {
				System.out.println(entry.getKey().hashCode());
			}
		}
	}
	
}