package cn.kidjoker.JavaExercise.StrategyPattern;

import org.junit.Test;

public class TestDiscount {

	@Test
	public void test() {
		DiscountContext boss = new DiscountContext();
		System.out.println(boss.getDiscountPrice(100));
		
		boss.changeStrategy(new VipDiscount());
		System.out.println(boss.getDiscountPrice(100));
		
		boss.changeStrategy(new newUserDiscount());
		System.out.println(boss.getDiscountPrice(100));
		
	}

}
