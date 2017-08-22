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
 *	创建时间: 2017年8月21日 - 下午4:21:43
 */
package cn.kidjoker.JavaExercise.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月21日 -下午4:21:43
 */
public class IntroSpectorDemo {
	
	public static void main(String[] args) {
		ReflectionDemo rd = new ReflectionDemo();
		rd.setName("jason");
		rd.setPos(1);
		rd.setSize(18);
		
		List<String> aList = new ArrayList<>();
		aList.add("abc");
		aList.add("def");
		rd.setaList(aList);
		
		//propertyDescriptorDemo(rd);
		
		//beanUtilDemo(rd);
		
		beanInfoDemo(rd);
	}
	
	public static void beanUtilDemo(ReflectionDemo rd) {
		String name = null;
		PropertyDescriptor pd = null;
		
		try {
			BeanUtils.setProperty(rd, "name", "jahs");
			name = BeanUtils.getProperty(rd, "name");
			
			System.out.println(rd.getName());
			
			name =BeanUtils.getProperty(rd, "aList");
			System.out.println(name);
			
			String[] list = BeanUtils.getArrayProperty(rd, "aList");
			System.out.println(Arrays.deepToString(list));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void beanInfoDemo(ReflectionDemo rd) {
		BeanInfo bi = null;
		String propName = "name";
		
		try {
			bi = Introspector.getBeanInfo(rd.getClass());
			PropertyDescriptor[] pds = bi.getPropertyDescriptors();
			
			for(PropertyDescriptor pd : pds) {
				if(pd.getName().equals(propName)) {
					System.out.println("beanInfo得到对应的PropertyDescripter" + pd.getReadMethod().invoke(rd, null));
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void propertyDescriptorDemo(ReflectionDemo rd) {
		PropertyDescriptor pd = null;
		
		try {
			pd = new PropertyDescriptor("name", rd.getClass());
			
			Class propClazz = pd.getPropertyType();
			System.out.println("属性的类型为: " + propClazz.getName());
			
			Method readMethod = pd.getReadMethod();
			Method writeMethod = pd.getWriteMethod();
			
			//调用写方法
			writeMethod.invoke(rd, "haha");
			System.out.println("设置name的属性: " + rd.getName());
			
			//调用读方法
			System.out.println("name属性的值为: " + readMethod.invoke(rd, null));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
