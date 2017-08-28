package cn.kidjoker.JavaExercise.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapTest {
	
	@Test public void test() {
		Map<String, Object> map = new HashMap<>(8,0.5f);
		map.put("hello1", "world");
		map.put("hello2", "world");
		map.put("hello3", "world");
		map.put("hello4", "world");
		map.put("hello5", "world");
		map.get("hello");
	}
	
}