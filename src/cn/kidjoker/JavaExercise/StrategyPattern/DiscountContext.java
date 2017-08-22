package cn.kidjoker.JavaExercise.StrategyPattern;

import org.junit.Test;

public class DiscountContext {

	private DiscountStrategy dStrategy;
	
	public DiscountContext() {
	}
	
	public DiscountContext(DiscountStrategy dStrategy) {
		this.dStrategy = dStrategy;
	}
	
	public double getDiscountPrice(double price) {
		if(dStrategy == null) {
			dStrategy = new OldDiscount();
		}
		return dStrategy.getPrice(price);
	}
	
	public void changeStrategy(DiscountStrategy dStrategy) {
		this.dStrategy = dStrategy;
	}
	
}
