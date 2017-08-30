package cn.kidjoker.JavaExercise.collection;

import java.util.LinkedHashSet;

import org.junit.Test;

public class LinkedHashSetTest {
	
	@Test public void test() {
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		
		lhs.add("123");
		lhs.add("456");
		lhs.add("789");
	}
}
