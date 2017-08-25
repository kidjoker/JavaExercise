/** work for life!
 * 
 */
package cn.kidjoker.JavaExercise.SimpleFactory;

/**
 * @author kidjoker
 *
 * @date 2017年8月25日 
 */
public abstract class AbstractOperator implements Operator {
	
	private double numberA;
	
	private double numberB;
	
	public double getNumberA() {
		return numberA;
	}

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}

	public double getNumberB() {
		return numberB;
	}

	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}

	@Override
	public abstract double GetResult() throws Exception;
}
