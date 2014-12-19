package com.ccnu.util;

public final  class Taxes {
	//���ֲ�ͬ��˰�Ŀ�����
	public static final Taxes I=new Taxes(5);
	public static final Taxes B_I=new Taxes(15);
	public static final Taxes B=new Taxes(10);
	public static final Taxes Free=new Taxes(0);
	private int taxRate;   //˰��
	
	Taxes(int rate){
		this.taxRate=rate;
	}
	public int getTaxRate(){
		return this.taxRate;
	
	}
	/**
	 *��ȡ��ǰ����˰������ Free--��˰ ��I--����˰��B--����˰��B_I--����˰+����˰
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
