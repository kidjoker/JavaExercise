package cn.kidjoker.JavaExercise.StrategyPattern;

public class newUserDiscount implements DiscountStrategy {

	@Override
	public double getPrice(double originPrice) {
		System.out.println("新用户打折策略");
		return originPrice * 0.85;
	}

}
