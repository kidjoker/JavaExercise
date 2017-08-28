package cn.kidjoker.JavaExercise.collection;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HashSetTest {
	@Test public void test() {
		Set<Object> set = new HashSet<>(10);
		set.add("123");
		set.add("456");
		set.add("789");
	}
}
