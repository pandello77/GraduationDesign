package com.ccnu.test;

import org.junit.BeforeClass;
import org.junit.Test;
import com.ccnu.util.GoodsInfo;
import com.ccnu.util.Receipt;



public class ReceiptTest {
	public static Receipt r;
	@BeforeClass
	public static void start(){
		r=new Receipt();
	}
	@Test
	public void testAddGoods(){
		System.out.println("****testAddGoods****");	
		r.addGoods(new GoodsInfo("1 music  CD at 14.99"));
		r.addGoods(new GoodsInfo("1 chocolate bar at 0.85"));
		System.out.println("Num: "+r.getGoods().size()+" TotalPrice:"+r.getTotalPrice());
	}
	
	@Test
	public void testShowReceipt(){
		System.out.println("****testShowReceipt****");	
		r.showReceipt();
	}

	/*  Input  1
	1 book at 12.49
	1 music  CD at 14.99
	1 chocolate bar at 0.85

	 *Input  2
	1 imported box of chocolates at 10.00
	1 imported bottle of perfume at 47.50


	 *Input  3
	1 imported bottle of perfume at 27.99
	1 bottle of perfume at 18.99
	1 packet of headache pills at 9.75
	1 box of imported  chocolates at 11.25
	 */
}
