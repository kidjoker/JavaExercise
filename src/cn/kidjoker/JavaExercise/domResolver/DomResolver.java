package cn.kidjoker.JavaExercise.domResolver;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import cn.kidjoker.JavaExercise.spring.bean.Person;

public class DomResolver {
	
	private static final Log Logger = LogFactory.getLog(DomResolver.class);
	
	@SuppressWarnings({ "unused", "unchecked" })
	@Test public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		//生成dom解析器
		SAXReader reader = new SAXReader();
		
		try {
			//通过文件系统获取文档
			Document document = reader.read(new File("d://spring-context.xml"));
			Element rootElement = document.getRootElement();
			List<Element> nodes = rootElement.elements();
			for(Element node : nodes) {
				String beanName = node.attributeValue("id");
				String className = node.attributeValue("class");
				
				Person person = (Person) Class.forName(className).newInstance();
				person.setPersonName("hahaha");
				System.out.println(person.getPersonName());
			}
		} catch (DocumentException e) {
			Logger.error("解析文档错误" + new Date());
			e.printStackTrace();
		}
	}
}
