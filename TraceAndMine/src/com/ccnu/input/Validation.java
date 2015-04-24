package com.ccnu.input;


import com.ccnu.dao.SequenceDao;
import com.ccnu.po.SequencePO;


public class Validation {
	public  static void validation(Buffer b,int id) throws Exception{
		boolean flag=true;
		 //验证结果
	      for(int i=0;i<Buffer._bufferSize;i++){
//	    	  System.out.println("i="+i+"v="+b.dataSet[i]);
				if(b.dataSet[i]!=i){
					flag=false;
					break;
				}
			}
	      System.out.println(flag);
	      SequenceDao d=new SequenceDao();
	      SequencePO po=d.findById(id);
	      po.setStatus(flag);
	      d.modify(po);
	    
	}
}
