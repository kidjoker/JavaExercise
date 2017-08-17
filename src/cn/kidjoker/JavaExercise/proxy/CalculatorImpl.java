package cn.kidjoker.JavaExercise.proxy;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -下午5:50:57
 */
public class CalculatorImpl implements Calculator {

	@Override
	public Integer add(Integer num1, Integer num2) {
		int ret = num1 + num2;
		System.out.println("in calculatorImpl,res: " + ret);
		return ret;
	}

	@Override
	public Integer mins(Integer num1, Integer num2) {
		int ret = num1 - num2;
		System.out.println("in calculatorImpl,res: " + ret);
		return ret;
	}

}
