package com.ccnu.action;

import com.ccnu.dao.SequenceDao;
import com.ccnu.dao.TraceDao;
import com.ccnu.input.test;

public class TraceAction {
	public void delete() throws Exception{
		TraceDao dao1 = new TraceDao();
		dao1.deleteAll();
		SequenceDao dao = new SequenceDao();
		dao.deleteAll();
		
	}
	public void start() throws Exception{
		test t=new test();
		for (int i=0;i<20;i++){
			if(i%5==0){
				t.wrong();
			}
			else if(i%5>1){
				t.notSure();
			}
			else{
				t.correct();
			}
		}
	}

}
