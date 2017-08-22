/*
 * ================================================================
 * Copyright 2008-2017 Everelegance.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Everelegance Corp. Ltd, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Everelegance.
 * 
 * OPay项目组
 *
 * ================================================================
 *  创建人: jinzhijie
 *	创建时间: 2017年8月22日 - 上午9:28:22
 */
package cn.kidjoker.JavaExercise.TDD;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月22日 -上午9:28:22
 */
public class PerfectNumberFinder1 {
	public static boolean isPrefect(int number) {
		
		List<Integer> factors = new ArrayList<>();
		factors.add(1);
		
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				factors.add(i);
				factors.add(number / i);
			}
		}
		
		int sum = 0;
		for(int n : factors) {
			sum += n;
		}
		
		if(sum == number) {
			System.out.println(number + " is prefect number");
			return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		for(int i = 0; i < 50; i++) {
			PerfectNumberFinder1.isPrefect(i);
		}
	}
}
