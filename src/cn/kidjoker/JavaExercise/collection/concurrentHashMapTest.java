package cn.kidjoker.JavaExercise.collection;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class concurrentHashMapTest {
	@Test public void test() {
		ConcurrentHashMap<String, Object> conMap = new ConcurrentHashMap<>(15,0.75f);
		
		conMap.put("hello1", "hello1");
		conMap.put("hello2", "hello2");
	}
}
