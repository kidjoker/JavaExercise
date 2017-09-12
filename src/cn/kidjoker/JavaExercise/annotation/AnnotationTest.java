package cn.kidjoker.JavaExercise.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationTest {
	
	@Drinked(isDrinked=true,isDriving=true,mood="sad")
	public void person1Drive() {
		System.out.println("l'am driving car");
	}
	
	@Drinked(isDrinked=true,isDriving=false,mood="happy")
	public void person2Drive() {
		System.out.println("l'am driving car");
	}
	
	@Drinked(isDrinked=false,isDriving=true,mood="happy")
	public void person3Drive() {
		System.out.println("l'am driving car");
	}
	
	@Test public void policeTest() {
		for (Method method : AnnotationTest.class.getMethods()) {
			for(Annotation annotaion : method.getAnnotations()) {
				if(annotaion.annotationType().isAssignableFrom(Drinked.class)) {
					Drinked person = (Drinked) annotaion;
					if(person.isDrinked()) {
						if(person.isDriving()) {
							System.out.println(method.getName().split("D")[0] + " is going to jail");
						}
					}
				}
			}
		}
	}
}
