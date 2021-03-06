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

import cn.kidjoker.JavaExercise.spring.bean.Family;
import cn.kidjoker.JavaExercise.spring.bean.Person;

public class UrlResourceTest {
	
	@SuppressWarnings("resource")
	@Test public void test() {
//		Resource resource = new ClassPathResource("spring-context.xml");
//		BeanFactory factory = new DefaultListableBeanFactory();
//		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//		reader.loadBeanDefinitions(resource);
		
		ClassPathXmlApplicationContext cpxat = new ClassPathXmlApplicationContext("spring-context.xml");
		Family family = (Family) cpxat.getBean("family");
		System.out.println(family);
		
	}
}
