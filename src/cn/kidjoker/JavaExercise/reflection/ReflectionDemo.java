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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class ReflectionDemo {
	
	public int pos;
	
	public String name;
	
	public int size;
	
	private final static double PI = 3.1415926;
	
	private List<String> aList = new ArrayList<>();
	
	public static double getPI() {
		return PI;
	}
	
	public ReflectionDemo() {
	}
	
	public ReflectionDemo(String s,int i) {
		
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

	public static void main(String[] args) throws Exception {
		//getClassTest();
		applyReflectChangeObjValDemo();  
        //reflectInvokeArrayDemo();  
        //printClass("cn.kidjoker.JavaExercise.reflection.ReflectionDemo");  
        //arraysAsListTest();  
	}
	
	private static void getClassTest() throws Exception {
		String str1 = "abc";
		
		Class c1 = str1.getClass();
		Class c2 = String.class;
		Class c3 = Class.forName("java.lang.String");
		
		Class c4 = int.class;
		System.out.println("c4 is primitive " + c4.isPrimitive());
		
		Class c5 = Integer.TYPE;
		System.out.println("c4 == c5 " + (c4 == c5));
		
		//***************************************************
		@SuppressWarnings("unchecked")
		Class<String> str2 = (Class<String>) Class.forName("java.lang.String");
		Constructor<String> constructor = str2.getConstructor();
		Constructor<String> constructor2 = str2.getConstructor(String.class);
		
		String s1 = constructor.newInstance();
		String s2 = constructor2.newInstance("hjah");
		
		System.out.println(s1);
	}
	
	private static void arraysAsListTest() throws Exception {
		int[] aArray = new int[]{1,2,3};
		List<int[]> aList = Arrays.asList(aArray);
		
		System.out.println(aList.size());
		
	}
	
	private static void reflectInvokeArrayDemo() throws Exception {
		ReflectionDemo rd = (ReflectionDemo) Class.forName("cn.kidjoker.JavaExercise.reflection.ReflectionDemo").newInstance();
		
		Method m1 = null;
		
		try {
			Class<? extends ReflectionDemo> c1 = rd.getClass();
			
			int[] intArr = new int[]{3,5};
			m1 = c1.getMethod("printIntArray", int[].class);
			m1.invoke(rd, intArr);
			
			String[] stringArr = new String[]{"abc","efg"};
			m1 = c1.getMethod("printStringArray", String[].class);
			m1.invoke(rd, (Object)stringArr);
			
			Integer[] integerArr = new Integer[]{3,5};
			m1 = c1.getMethod("printIntegerArray", Integer[].class);
			m1.invoke(rd, (Object)integerArr);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	//输出类信息
	public static void printClass(String className) {
		List<String> list = new ArrayList<>();
		Class<?> clazz = null;
		
		try {
			clazz = Class.forName(className);
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException("类名有问题,请重新输入!");
		}
		
		StringBuilder sb = new StringBuilder();
		
		//输出类修饰符
		String modifierName = Modifier.toString(clazz.getModifiers());
		sb.append("类信息: ");
		if(modifierName != null && modifierName.length() != 0) {
			sb.append(modifierName + " ");
		}
		
		//输出类名称
		sb.append(clazz.getName());
		sb.append("\n");
		
		//输出属性信息
		sb.append("属性信息:");
		printFields(clazz,sb);
		sb.append("\n");
		
		//输出构造方法信息
		sb.append("构造器信息: ");
		printConstructors(clazz, sb);
		sb.append("\n");
		
		//输出方法信息
		sb.append("方法信息: ");
		printMethods(clazz, sb);
		sb.append("\n");
		
		System.out.println(sb);
	}
	
	public static void printIntArray(int[] array) {
		System.out.println("------printIntArray invoked------");
		for(int args : array) {
			System.out.println(args);
		}
	}
	
	public static void printStringArray(String[] array) {
		System.out.println("------printStringArray invoked------");
		for(String s : array) {
			System.out.println(s);
		}
	}
	
	public static void printIntegerArray(Integer[] array) {
		System.out.println("-------printIntegerArray invoked------");
		for(Integer i : array) {
			System.out.println(i);
		}
	}
	
	public static void printFields(Class<?> clazz,StringBuilder sb) {
		Field[] fields = clazz.getFields();
		
		for(Field field : fields) {
			sb.append(Modifier.toString(field.getModifiers()));
			sb.append(" " + field.getType() + " " + field.getName());
			sb.append(",");
		}
		
		if(fields != null && fields.length != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void printConstructors(Class<?> clazz,StringBuilder sb) {
		Constructor<?>[] cons = clazz.getConstructors();
		
		for(Constructor<?> con : cons) {
			sb.append(Modifier.toString(con.getModifiers()));
			sb.append(" " + con.getName() + "(");
			Class<?>[] types = con.getParameterTypes();
			for(Class<?> type : types) {
				sb.append(type.getName() + ",");
			}
			if(types != null & types.length != 0) {
				sb.deleteCharAt(sb.length()-1);
			}
			
			sb.append(")");
			sb.append(",");
		}
		if(cons != null && cons.length != 0) {
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void printMethods(Class<?> clazz,StringBuilder sb) {
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			sb.append(Modifier.toString(method.getModifiers()));
			sb.append(" " + method.getReturnType() + " " + method.getName() + "(");
			
			Class<?>[] types = method.getParameterTypes();
			for(Class<?> type : types) {
				sb.append(type.getName());
				sb.append(",");
			}
			if(types != null & types.length != 0) {
				sb.deleteCharAt(sb.length()-1);
			}
			
			sb.append(")");
			sb.append(",");
		}
		if(methods != null && methods.length != 0) {
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	private static void applyReflectChangeObjValDemo() {
		ReflectionDemo rd = null;
		Method m1 = null;
		try {
			rd = (ReflectionDemo) Class.forName("cn.kidjoker.JavaExercise.reflection.ReflectionDemo").newInstance();
			m1 = rd.getClass().getMethod("setName", String.class);
			m1.invoke(rd, "jason");
			
			m1 = rd.getClass().getMethod("getName");
			System.out.println(m1.invoke(rd, null));
		}
		catch (Exception e) {
			throw new RuntimeException("error");
		}
	}
}
