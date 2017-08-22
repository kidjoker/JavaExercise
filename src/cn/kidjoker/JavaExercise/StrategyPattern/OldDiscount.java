package cn.kidjoker.JavaExercise.StrategyPattern;

public class OldDiscount implements DiscountStrategy{

	@Override
	public double getPrice(double originPrice) {
		System.out.println("旧书打折策略");
		return originPrice * 0.9;
	}

}
