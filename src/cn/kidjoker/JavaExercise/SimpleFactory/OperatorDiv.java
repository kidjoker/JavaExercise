/** work for life!
 * 
 */
package cn.kidjoker.JavaExercise.SimpleFactory;

/**
 * @author kidjoker
 *
 * @date 2017年8月25日 
 */
public class OperatorDiv extends AbstractOperator {

	@Override
	public double GetResult() throws Exception {
		double result = 0;
		if(getNumberB() == 0) {
			throw new Exception("除数不能为0");
		}
		result = getNumberA() / getNumberB();
		return result;
	}

}
