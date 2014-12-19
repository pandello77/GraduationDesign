package com.ccnu.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodsInfo {
	private Taxes tax;// 税费类型
	private double taxes;// 税费的值
	private String info;// 商品信息
	private int num;// 商品数量
	private double shelfPrice;// 商品单价
	private double allPrice;// 商品总价
	final static String[] keyWord = { "pills", "food", "fruit", "book",
			"chocolates", "chocolate" };// 关键字代表可以免基本税的商品

	public GoodsInfo(){
		
	} 
	/**
	 * 构造方法，判断商品的交税类型以及计算出交税的部分
	 * 
	 * @param info
	 *            输入信息
	 * @author Jane 2014-10-11
	 */
	public GoodsInfo(String info) {
		// 从输入的商品信息中获得 数量 、单价、商品类型的信息

		this.tax = autoTax(info);
		if (!info.split(" ")[0].isEmpty())
			this.num = Integer.valueOf(info.split(" ")[0]).intValue();
		if (!info.split(" ")[0].isEmpty())
			this.info = info.substring(info.indexOf(" "), info.indexOf(" at "));

		BigDecimal shelfPrice_B = new BigDecimal(info.substring(info
				.indexOf(" at ") + 4));
		this.shelfPrice = shelfPrice_B.doubleValue();
		this.shelfPrice = round(this.shelfPrice, 2);

		BigDecimal taxRate_B = new BigDecimal(this.tax.getTaxRate());
		BigDecimal taxes_B = shelfPrice_B.multiply(taxRate_B);
		taxes_B = taxes_B.multiply(new BigDecimal(num));
		taxes_B = taxes_B.multiply(new BigDecimal(0.01));
		this.taxes = taxes_B.doubleValue();
		this.taxes = Math.ceil(this.taxes * 20) / 20;// 实现向最近的0.05取近似值

		this.allPrice = shelfPrice_B.add(new BigDecimal(taxes)).doubleValue();// 求总价
		this.allPrice = round(this.allPrice, 2);

	}

	/**
	 * 对double数据进行取精度.
	 * 
	 * @param value
	 *            double数据.
	 * @param roundingMode
	 *            精度取值方式.
	 * @return 精度计算后的数据.
	 * @author Jane 2014-10-11
	 */
	public double round(double value, int scale) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);// 实现四舍五入
		double d = bd.doubleValue();
		TraceEntity.displayStackTraceInformation(new Throwable(),true);
		return d;
	}



	/**
	 * 根据输入信息判断交税的比例
	 * 
	 * @param inf
	 *            o 输入信息
	 * @return 分析后交税的类型
	 * @author Jane 2014-10-11
	 */
	public static Taxes autoTax(String info) {
		Set<String> setInfo = new HashSet<String>(
				Arrays.asList(info.split(" ")));
		Set<String> setKeyWord = new HashSet<String>(Arrays.asList(keyWord));
		Set<String> A = new HashSet<String>();
		A.addAll(setInfo);
		A.addAll(setKeyWord);
		if (A.size() == setInfo.size() + setKeyWord.size()) {// 有基本税
			return setInfo.contains("imported") ? Taxes.B_I : Taxes.B;
		} else {// 无基本税
			return setInfo.contains("imported") ? Taxes.I : Taxes.Free;
		}
	}

	/* get set 方法 */
	public String getTaxType() {
		return "税费类别" + tax.getTaxType();
	}

	public Taxes getTax() {
		return tax;
	}

	public void setTax(Taxes tax) {
		this.tax = tax;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getShelfPrice() {
		return shelfPrice;
	}

	public void setShelfPrice(double shelfPrice) {
		this.shelfPrice = shelfPrice;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

}
