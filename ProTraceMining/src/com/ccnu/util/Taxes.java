package com.ccnu.util;

public final  class Taxes {
	//各种不同的税的可能性
	public static final Taxes I=new Taxes(5);
	public static final Taxes B_I=new Taxes(15);
	public static final Taxes B=new Taxes(10);
	public static final Taxes Free=new Taxes(0);
	private int taxRate;   //税率
	
	Taxes(int rate){
		this.taxRate=rate;
	}
	public int getTaxRate(){
		return this.taxRate;
	
	}
	/**
	 *获取当前所交税的类型 Free--免税 ，I--进口税，B--基本税，B_I--进口税+基本税
	 * @author Jane 2014-10-11
	 */
	public String getTaxType(){
		if(0==this.taxRate){
			return "Free";
		}
		if(5==this.taxRate){
			return "I";
		}
		if(10==this.taxRate){
			return "B";
		}
		if(15==this.taxRate){
			return "B_I";
		}
		return null;
	}
}
