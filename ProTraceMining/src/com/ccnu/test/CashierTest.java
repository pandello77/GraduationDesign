package com.ccnu.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ccnu.util.Cashier;
import com.ccnu.util.GoodsInfo;
import com.ccnu.util.Receipt;



public class CashierTest {
	public static Cashier c;
	@BeforeClass
	public static void start(){
		c=new Cashier();		
	}
	@Test
	public void testAddGoodsToReceipt(){
		Receipt r=new Receipt();
		c.addGoodsToReceipt(r, new GoodsInfo("1 music  CD at 14.99"));
		r.showReceipt();
	}
	@Test
	public void testShowReceipt(){
		Receipt r=new Receipt();
		c.addGoodsToReceipt(r, new GoodsInfo("1 music  CD at 14.99"));
		c.showReceipt(r);
	}

}
