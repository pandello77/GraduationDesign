package com.ccnu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Cashier {
	/**
	 *����һ���µ�СƱ
	 *@return ���ɵ��µ�СƱ
	 * @param ����ӵ���Ʒ��Ϣ
	 * @author Jane 2014-10-11
	 */
	public Receipt newReceipt(){
		return new Receipt();
	}
	
	/**
	 * ��СƱ���������Ʒ��Ϣ
	 * 
	 * @param r
	 *            ��ǰСƱ��Ϣ
	 * @param ����ӵ���Ʒ��Ϣ
	 * @author Jane 2014-10-11
	 */
	public void addGoodsToReceipt(Receipt r, GoodsInfo goods) {
		r.addGoods(goods);
	}

	/**
	 * ��ʾСƱϴ��Ϣ
	 * 
	 * @param r
	 *            ��ǰСƱ��Ϣ
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
		while (!(line = br.readLine()).isEmpty()) {// �ӿ���̨������ �Կ��н�β
			GoodsInfo newGoods = new GoodsInfo(line);
			cashier.addGoodsToReceipt(r, newGoods);
		}
		cashier.showReceipt(r);
	}
}
