package com.ccnu.aspect;

import com.ccnu.dao.SequenceDao;
import com.ccnu.dao.TraceDao;
import com.ccnu.input.Buffer;
import com.ccnu.po.TracePO;

public final aspect MonitorThread extends AbstractAspectJ{
	TraceDao dao=new TraceDao();//����·���ڵ���Ϣ
	SequenceDao sdao=new SequenceDao();//ִ��·����Ϣ
	int  sequenceID=sdao.getMaxSeqID();//��ȡ��ǰ��·��ID
	
	pointcut pRead(Buffer buffer,int lineNumber) : 
		execution(* com.ccnu.input.Buffer.read(int))&&target(buffer)&&args(lineNumber);
	pointcut pWrite(Buffer buffer,int lineNumber,int data) : 
		execution(* com.ccnu.input.Buffer.write(int,int))&&target(buffer)&&args(lineNumber,data)
		&&!within(MonitorThread);

	after(Buffer buffer,int lineNumber) :pRead(buffer,lineNumber){
		TracePO po=transform(buffer,lineNumber,thisJoinPoint,true,sequenceID+1);
		try {
			dao.add(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	after(Buffer buffer,int lineNumber,int data) :pWrite(buffer,lineNumber,data){
		TracePO po=transform(buffer,lineNumber,thisJoinPoint,true,sequenceID+1);
		try {
			dao.add(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
