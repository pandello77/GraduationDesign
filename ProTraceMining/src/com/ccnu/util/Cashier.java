package com.ccnu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Cashier {
	/**
	 *生成一张新的小票
	 *@return 生成的新的小票
	 * @param 新添加的商品信息
	 * @author Jane 2014-10-11
	 */
	public Receipt newReceipt(){
		return new Receipt();
	}
	
	/**
	 * 向小票添加其他商品信息
	 * 
	 * @param r
	 *            当前小票信息
	 * @param 新添加的商品信息
	 * @author Jane 2014-10-11
	 */
	public void addGoodsToReceipt(Receipt r, GoodsInfo goods) {
		r.addGoods(goods);
	}

	/**
	 * 显示小票洗信息
	 * 
	 * @param r
	 *            当前小票信息
	 * @author Jane 2014-10-11
	 */
	public void showReceipt(Receipt r) {
		r.showReceipt();
	}

	public static void main(String[] args) throws IOException {
		Cashier cashier = new Cashier();
		Receipt r = cashier.newReceipt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while (!(line = br.readLine()).isEmpty()) {// 从控制台的输入 以空行结尾
			GoodsInfo newGoods = new GoodsInfo(line);
			cashier.addGoodsToReceipt(r, newGoods);
		}
		cashier.showReceipt(r);
	}
}
