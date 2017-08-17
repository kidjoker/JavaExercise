package cn.kidjoker.JavaExercise.proxy;

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
		ProxyUtils.saveProxyClass("D:/KidjokeR/aaa.class", "$Proxy0", CalculatorImpl.class.getInterfaces());
	}
	
}
