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
 *	创建时间: 2017年8月17日 - 下午5:58:21
 */
package cn.kidjoker.JavaExercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.INV_OBJREF;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -下午5:58:21
 */
public class CalculatorHandler implements InvocationHandler {

	private Object obj;
	
	public CalculatorHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("in staticCalculatorProxy,before invocation");
		Object ret = method.invoke(obj, args);
		System.out.println("in staticCalculatorProxy,after invocation");
		return ret;
	}
	
	public static void main(String[] args) {
		CalculatorImpl obj = new CalculatorImpl();
		CalculatorHandler handler = new CalculatorHandler(obj);
		Calculator calculator = (Calculator) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		
		System.out.println(calculator.add(1, 2));
		
		System.out.println("**********************************************");
		
		System.out.println(calculator.mins(2, 1));
	}

}
