package cn.kidjoker.JavaExercise.proxy;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -下午5:53:07
 */
public class StaticCalculatorProxy implements Calculator {

	private Calculator obj;
	
	public StaticCalculatorProxy(Calculator obj) {
		this.obj = obj;
	}

	@Override
	public Integer add(Integer num1, Integer num2) {
		System.out.println("in staticCalculatorProxy,before invocation");
		int ret = obj.add(num1, num2);
		System.out.println("in staticCalculatorProxy,after invocation");
		return ret;
	}

	@Override
	public Integer mins(Integer num1, Integer num2) {
		System.out.println("in staticCalculatorProxy,before invocation");
		int ret = obj.mins(num1, num2);
		System.out.println("in staticCalculatorProxy,after invocation");
		return ret;
	}
	
	public static void main(String[] args) {
		Calculator obj = new CalculatorImpl();
		StaticCalculatorProxy scp = new StaticCalculatorProxy(obj);
		
		scp.add(1, 2);
		
		System.out.println("####################################");
		
		scp.mins(2, 1);
	}

}
