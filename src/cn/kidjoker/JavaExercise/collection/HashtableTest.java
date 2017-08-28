package cn.kidjoker.JavaExercise.collection;

import java.util.Hashtable;

import org.junit.Test;

public class HashtableTest {
	@Test public void test() {
		Hashtable<String, Object> table = new Hashtable<>(8, 0.5f);
		
		table.put("hello1", "hello1");
	}
}
