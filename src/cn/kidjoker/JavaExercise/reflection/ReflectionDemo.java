/*
 * ================================================================
 * Copyright 2008-2017 Everelegance.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Everelegance Corp. Ltd, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Everelegance.
 * 
 * OPay项目组
 *
 * ================================================================
 *  创建人: jinzhijie
 *	创建时间: 2017年8月21日 - 上午11:21:03
 */
package cn.kidjoker.JavaExercise.reflection;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.sun.corba.se.spi.orb.StringPair;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月21日 -上午11:21:03
 */
public class ReflectionDemo implements Serializable,Cloneable {
	
	private int pos;
	
	private String name;
	
	private int size;
	
	private final static double PI = 3.1415926;
	
	private List<String> aList = new ArrayList<>();
	
	public ReflectionDemo() {
	}
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<String> getaList() {
		return aList;
	}

	public void setaList(List<String> aList) {
		this.aList = aList;
	}
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@Test public void test() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		
		//通过反射生成对象
		Class c1 = Class.forName("cn.kidjoker.JavaExercise.reflection.ReflectionDemo");
		ReflectionDemo rd =  (ReflectionDemo) c1.newInstance();
		
		//获取类名
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		
		//获取访问权限值
		int modifiers = c1.getModifiers();
		System.out.println(Modifier.isPublic(modifiers));
		
		//获取包信息
		Package package1 = c1.getPackage();
		
		//获取父类class对象
		Class cParent = c1.getSuperclass();
		
		//获取声明接口信息
		Class[] interfaces = c1.getInterfaces();
		
		//构造器
		Constructor[] ctr = c1.getConstructors();
		
		//属性信息
		Field field = c1.getDeclaredField("pos");
		field.set(rd, 5);
		
		Field fieldt = c1.getDeclaredField("aList");
		Type typet = fieldt.getGenericType();
		if(typet instanceof ParameterizedType) {
			ParameterizedType typett = (ParameterizedType)typet;
			for(Type typeqq : typett.getActualTypeArguments()) {
				System.out.println(typeqq);
			}
		}

		
		Annotation[] annos = c1.getAnnotations();
		
		Method m = c1.getDeclaredMethod("setaList", new Class[]{List.class});
		Type[] paramType = m.getGenericParameterTypes();
		for(Type type : paramType) {
			if(type instanceof ParameterizedType) {
				ParameterizedType paramterizeType = (ParameterizedType) type;
				for(Type typettt : paramterizeType.getActualTypeArguments()) {
					System.out.println(typettt);
				}
			}
		}
		
		int[] array = (int[]) Array.newInstance(int.class, 5);
		
		Array.set(array, 0, 123);
		Array.set(array, 1, 465);
		Array.set(array, 2, 789);
		
		System.out.println(Array.get(array, 1));
		
		Class arrayClass = Class.forName("I");
		arrayClass.newInstance();
	}
}
