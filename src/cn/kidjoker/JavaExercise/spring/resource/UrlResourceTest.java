package cn.kidjoker.JavaExercise.spring.resource;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.kidjoker.JavaExercise.spring.bean.Person;

public class UrlResourceTest {
	
	@Test public void test() {
//		Resource resource = new ClassPathResource("spring-context.xml");
//		BeanFactory factory = new DefaultListableBeanFactory();
//		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//		reader.loadBeanDefinitions(resource);
		
		ClassPathXmlApplicationContext cpxat = new ClassPathXmlApplicationContext("spring-context.xml");
		Person person = (Person) cpxat.getBean("person1");
		person.setPersonAge(35);
		System.out.println(person);
	}
}
