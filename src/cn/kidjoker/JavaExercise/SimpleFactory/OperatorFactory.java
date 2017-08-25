/** work for life!
 * 
 */
package cn.kidjoker.JavaExercise.SimpleFactory;

/**
 * @author kidjoker
 *
 * @date 2017年8月25日 
 */
public class OperatorFactory {
	
	public static Operator createOperator(String operate) {
		Operator operator = null;
		switch (operate) {
			case "+":
				operator = new OperatorAdd();
				break;
			case "-":
				operator = new OperatorSub();
				break;
			case "*":
				operator = new OperatorMul();
				break;
			case "/":
				operator = new OperatorDiv();
				break;
			case "%":
				operator = new OperatorMod();
			default:
				break;
		}
		return operator;
	}
}
