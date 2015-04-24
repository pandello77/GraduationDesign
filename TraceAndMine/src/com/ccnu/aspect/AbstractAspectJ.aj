package com.ccnu.aspect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;

import com.ccnu.dao.SequenceDao;
import com.ccnu.input.Buffer;
import com.ccnu.po.TracePO;

public abstract aspect AbstractAspectJ {

	public TracePO transform(Buffer buffer,int lineNumber,JoinPoint j,boolean status,int sequenceID){
		TracePO po=new TracePO();
		SequenceDao sdo=new SequenceDao();
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String date=format.format(new Date());
		try {
			po.setDate(sfd.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		po.setMethodLine(j.getSourceLocation().getLine());
		po.setMethodName(j.getSignature().getName());
		po.setMillisecond(Integer.valueOf(date.substring(date.indexOf('.')+1)));
		po.setShareMemoryIndex(lineNumber);
		po.setShareMemoryValue(Integer.toString(buffer.dataSet[lineNumber]));
		po.setThreadID((int) Thread.currentThread().getId());
		po.setThreadName(Thread.currentThread().getName());
		try {
			po.setSequence(sdo.findById(sdo.getMaxSeqID()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}

}
