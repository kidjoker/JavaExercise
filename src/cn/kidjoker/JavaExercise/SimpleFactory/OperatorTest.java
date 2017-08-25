/** work for life!
 * 
 */
package cn.kidjoker.JavaExercise.SimpleFactory;

import java.util.Scanner;

/**
 * @author kidjoker
 *
 * @date 2017年8月25日 
 */
public class OperatorTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		AbstractOperator operator = null;
		System.out.println("请输入您要的算法:\t");
		operator = (AbstractOperator) OperatorFactory.createOperator(scanner.next());
		
		System.out.println("请输入数字A:\t");
		operator.setNumberA(scanner.nextInt());
		
		System.out.println("请输入数字B:\t");
		operator.setNumberB(scanner.nextInt());
		
		System.out.println("运算结果是: " + operator.GetResult());
	}
}
