package com.ccnu.input;


import com.ccnu.dao.SequenceDao;
import com.ccnu.input.AddThread;
import com.ccnu.input.Buffer;
import com.ccnu.input.ReaderThread;
import com.ccnu.input.SubtractionThread;
import com.ccnu.po.SequencePO;


public class test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		test t=new test();
		for (int i=0;i<30;i++){
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
	public void wrong() throws Exception{
		 Buffer b = new Buffer();  
		  Thread t_init=new Thread(new InitThread(b),"set");
	      Thread tr = new Thread(new ReaderThread(b,0),"reader1"); 
	      Thread tSub1 = new Thread(new SubtractionThread(b,0),"sub"); 
	      Thread tAdd1 = new Thread(new AddThread(b,0),"add"); 
	   
	      SequencePO spo=new SequencePO();
	      SequenceDao dao=new SequenceDao();
	      dao.add(spo);
	     
	    
	      tAdd1.start(); 
	      t_init.start();
	     
	      tr.start();  
	      tSub1.start();
	      
	      tAdd1.join();
	      tSub1.join();
	     
	      tr.join();
	      t_init.join();
	      Validation.validation(b,dao.getMaxSeqID()); 
	}
	public void notSure() throws Exception{
		 Buffer b = new Buffer();  
		  Thread t_init=new Thread(new InitThread(b),"init");
	      Thread tr = new Thread(new ReaderThread(b,0),"reader1"); 
	      Thread tSub1 = new Thread(new SubtractionThread(b,0),"sub"); 
	      Thread tAdd1 = new Thread(new AddThread(b,0),"add"); 
	   
	      SequencePO spo=new SequencePO();
	      SequenceDao dao=new SequenceDao();
	      dao.add(spo);
	     
	      t_init.start();
	      tAdd1.start(); 
	      tr.start();  
	      tSub1.start();
	      
	      tAdd1.join();
	      tSub1.join();
	      t_init.join();
	      tr.join();
	      Validation.validation(b,dao.getMaxSeqID()); 
	      System.out.println("end");
	}
	
	
	public void correct() throws Exception{
		  Buffer b = new Buffer();  
		  Thread t_init=new Thread(new InitThread(b),"init");
	      Thread tr = new Thread(new ReaderThread(b,0),"reader1"); 
	      Thread tSub1 = new Thread(new SubtractionThread(b,0),"sub"); 
	      Thread tAdd1 = new Thread(new AddThread(b,0),"add"); 
	   
	      SequencePO spo=new SequencePO();
	      SequenceDao dao=new SequenceDao();
	      dao.add(spo);
	     
	      t_init.start();
	      t_init.join();
	      
	      tAdd1.start(); 
	      tAdd1.join();
	      
	      tr.start();  
	      tr.join();
	      
	      tSub1.start();
	      tSub1.join();	     
	      Validation.validation(b,dao.getMaxSeqID()); 
	}
}
