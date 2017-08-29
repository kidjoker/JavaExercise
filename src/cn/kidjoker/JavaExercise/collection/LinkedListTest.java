package cn.kidjoker.JavaExercise.collection;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {
	@Test public void test() {
		List<String> list = new LinkedList<>();
		
		list.add("1");
		list.add("2");
		list.add("2");
		list.add(3,"2");
		list.add(3,"a");
		list.add("2");
		list.add("2");
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
