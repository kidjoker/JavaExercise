package cn.kidjoker.JavaExercise.spring.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingleClass {
	
	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		Person person = ctx.getBean(Person.class);
	}
}
