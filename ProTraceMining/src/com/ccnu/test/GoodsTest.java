package com.ccnu.test;


import org.junit.BeforeClass;
import org.junit.Test;
import com.ccnu.util.GoodsInfo;


public class GoodsTest {
	public static GoodsInfo goods;

	@BeforeClass
	public static void testConstructor() {
		System.out.println("****Constructor****");
		goods = new GoodsInfo("1 imported bottle of perfume at 27.99");
		System.out.println(goods.getNum() + goods.getInfo() + ":  "
				+ goods.getAllPrice() + "Tax:" + goods.getTaxes());
	
	}

	@Test
	public void testRound() {
		System.out.println("****testRoundr****");
		double val = 12.03456;
		for (int scale = 0; scale < 6; scale++) {
			System.out.println("scale:  " + scale + "  result:  "
					+ GoodsInfo.round(val, scale));
		}
	}

	@Test
	public void testAutoTax() {
		String info = new String("1 box of imported  chocolates at 11.25");
		System.out.println("****testAutoTax****");
		System.out.println(info);
		System.out
				.println("TaxType is " + GoodsInfo.autoTax(info).getTaxType());

	}

}
