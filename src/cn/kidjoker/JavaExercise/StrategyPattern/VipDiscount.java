package cn.kidjoker.JavaExercise.StrategyPattern;

public class VipDiscount implements DiscountStrategy{

	@Override
	public double getPrice(double originPrice) {
		System.out.println("vip 促销模式");
		return originPrice * 0.5;
	}

}
