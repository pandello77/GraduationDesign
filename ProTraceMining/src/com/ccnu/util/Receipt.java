package com.ccnu.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Receipt {
	private LinkedList<GoodsInfo> goods = new LinkedList<GoodsInfo>();// 商品信息
	private double taxes;// 所有税费之和
	private double totalPrice;// 商品总价之和
	public static final int lineSize = 29;// 小票每行最多字符数

	
	/**
	 * 向当前小票添加新的商品
	 * 
	 * @param goods
	 *            新的商品信息
	 * @author Jane 2014-10-11
	 */
	public void addGoods(GoodsInfo goods) {
		this.goods.add(goods);
		BigDecimal totalPrice_B = new BigDecimal(
				Double.toString(this.totalPrice));
		BigDecimal taxes_B = new BigDecimal(Double.toString(this.taxes));

		this.taxes = taxes_B.add(new BigDecimal(goods.getTaxes()))
				.doubleValue();
		this.totalPrice = totalPrice_B.add(new BigDecimal(goods.getAllPrice()))
				.doubleValue();
		this.totalPrice = GoodsInfo.round(this.totalPrice, 2);
		this.taxes = GoodsInfo.round(this.taxes, 2);
	}

	/**
	 * 显示当前小票的信息
	 * 
	 * @author Jane 2014-10-11
	 */
	public void showReceipt() {
		DecimalFormat df = new DecimalFormat("#0.000");
		DecimalFormat df2 = new DecimalFormat("#0.00");
		System.out.println("T1: "+totalPrice);
		System.out.println("T2: "+goods.get(0).getAllPrice());
		for (int i = 0; i < goods.size(); i++) {
			int j = 0;
			String printStr = goods.get(i).getNum() + goods.get(i).getInfo()
					+ ":" + df.format(goods.get(i).getAllPrice());
			// 保证不会一行输出过多字符
			int len = printStr.length();
			while (len > lineSize) {
				System.out.println(printStr.substring(lineSize * j, lineSize
						* j + lineSize));
				len -= lineSize;
				j++;
			}
			System.out.println(printStr.substring(lineSize * j,
					printStr.length() - 1));
		}
		System.out.println("Sales Taxes: " + df2.format(taxes));
		System.out.println("Total: " + df2.format(totalPrice));
	}

	public LinkedList<GoodsInfo> getGoods() {
		return goods;
	}

	public double getTaxes() {
		return taxes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

}
