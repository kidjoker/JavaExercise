package cn.kidjoker.JavaExercise.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {
	@Test public void test() {
		List<String> list = new ArrayList<>(10);
		list.add("2");
		list.add(1,"3");
		list.set(1, "4");
		
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add(1,"b");
		list2.addAll(0,list);
		
		list2.remove("a");
		list2.remove(2);
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
