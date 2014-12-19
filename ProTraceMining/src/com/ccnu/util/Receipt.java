package com.ccnu.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Receipt {
	private LinkedList<GoodsInfo> goods = new LinkedList<GoodsInfo>();// ��Ʒ��Ϣ
	private double taxes;// ����˰��֮��
	private double totalPrice;// ��Ʒ�ܼ�֮��
	public static final int lineSize = 29;// СƱÿ������ַ���

	
	/**
	 * ��ǰСƱ����µ���Ʒ
	 * 
	 * @param goods
	 *            �µ���Ʒ��Ϣ
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
	 * ��ʾ��ǰСƱ����Ϣ
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
			// ��֤����һ����������ַ�
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
