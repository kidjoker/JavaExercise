/** work for life!
 * 
 */
package cn.kidjoker.JavaExercise.SimpleFactory;

/**
 * @author kidjoker
 *
 * @date 2017年8月25日 
 */
public class OperatorMul extends AbstractOperator {

	@Override
	public double GetResult() {
		double result = 0;
		result = getNumberA() * getNumberB();
		return result;
	}

}
