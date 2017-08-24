package cn.kidjoker.JavaExercise.proxy;

import java.lang.reflect.Proxy;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -下午6:48:28
 */
public class MainTest {
	
	public static void main(String[] args) {
		Calculator c1 = new CalculatorImpl();
		
		ProxyUtils.saveProxyClass("D:\\aaa.class", "bbb", Calculator.class.getInterfaces());
		
		CalculatorHandler handler = new CalculatorHandler(c1);
		
		Calculator c2 = (Calculator)Proxy.newProxyInstance(handler.getClass().getClassLoader(), c1.getClass().getInterfaces(), handler);
		
		c1.add(1, 2);
		c1.mins(2, 1);
		System.out.println("**************");
		c2.add(1, 2);
		c2.mins(2, 1);
		
		Locale locale = Locale.getDefault();
		//System.out.println(locale.toString());
	}
	
}
