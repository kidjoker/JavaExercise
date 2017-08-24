package cn.kidjoker.JavaExercise.spring.resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.kidjoker.JavaExercise.spring.bean.Person;

public class UrlResourceTest {
	
	@SuppressWarnings("resource")
	@Test public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		
		Person person = context.getBean(Person.class);
		person.setPersonAge(35);
		System.out.println(person);
	}
}
