package com.ccnu.util;

import java.util.ArrayList;
import java.util.List;

import com.ccnu.algo.datastructures.Sequence;
import com.ccnu.algo.datastructures.SequenceDatabase;
import com.ccnu.dao.SequenceDao;
import com.ccnu.po.SequencePO;
import com.ccnu.po.TracePO;

public class DataToSequence {

	public static SequenceDatabase getAllSequenceFromDB() throws Exception {
		SequenceDao dao = new SequenceDao();
		List<SequencePO> allSeq = dao.getAll("SequencePO");
		return DataToSequences(allSeq);
	}
	public static SequenceDatabase getTrueSequenceFromDB() throws Exception {
		SequenceDao dao = new SequenceDao();
		List<SequencePO> trueSeq = dao.getTrue("SequencePO");
		return DataToSequences(trueSeq);
	}
	public static SequenceDatabase getFalseSequenceFromDB() throws Exception {
		SequenceDao dao = new SequenceDao();
		List<SequencePO> trueSeq = dao.getFalse("SequencePO");
		return DataToSequences(trueSeq);
	}
	public static SequenceDatabase DataToSequences(List<SequencePO> listSequencePO) {
		int id = 0;
		SequenceDatabase sequenceDatabase = new SequenceDatabase();
	
		for (SequencePO p : listSequencePO) {
			
			Sequence s = new Sequence(id++);
			List<Integer> itemset = new ArrayList<Integer>();
			List<TracePO> traceList = p.getTraceList();
			int data=traceList.get(0).getMillisecond();
			for (TracePO t : traceList) {
				int ind;
				if(t.getMethodName().contains("read"))
					ind=t.getShareMemoryIndex() * 2 + 1;
				else
					ind=t.getShareMemoryIndex() * 2;
				if((t.getMillisecond()-data>-40)&&(t.getMillisecond()-data<45)){
					itemset.add(ind);
				}
				else{
					s.addItemset(itemset);
					itemset = new ArrayList<Integer>();
					itemset.add(ind);
					data=t.getMillisecond();
				}
			}
			if(itemset.size()>0){
			s.addItemset(itemset);
			}
			sequenceDatabase.addSequence(s);
		}
		System.out.println(sequenceDatabase.toString());
		return sequenceDatabase;
	}

//	public static SequenceDatabase DataToSequences(List<SequencePO> listSequencePO) {
//		int id = 0;
//		SequenceDatabase sequenceDatabase = new SequenceDatabase();
//		for (SequencePO p : listSequencePO) {
//			List<TracePO> traceList = p.getTraceList();
//			Sequence s = new Sequence(id++);
//			List<Integer> itemset = new ArrayList<Integer>();
//			//奇数为读 偶数为写
//			for (TracePO t : traceList) {
//				if(itemset.size()==0||t.getMethodName().contains("read")){//itemset为空或者trace为读
//					if(t.getMethodName().contains("read")){
//					itemset.add(t.getShareMemoryIndex() * 2 + 1);
//					}
//					else{
//						itemset.add(t.getShareMemoryIndex() * 2 );
//						}
//				}
//				else if(itemset.contains(t.getShareMemoryIndex() * 2) == false){
//					itemset.add(t.getShareMemoryIndex() * 2 );
//				}
//				else{
//					s.addItemset(itemset);
//					itemset = new ArrayList<Integer>();
//					itemset.add(t.getShareMemoryIndex() * 2 );
//				}
//				if(itemset.size()>3){
//					s.addItemset(itemset);
//					itemset = new ArrayList<Integer>();
//				}
//			}
//			sequenceDatabase.addSequence(s);
//		}
//		System.out.println(sequenceDatabase.toString());
//		return sequenceDatabase;
//	}
	
	
	public static Sequence PoToSequence(SequencePO p){
		List<TracePO> traceList = p.getTraceList();
		Sequence s = new Sequence(1);
		List<Integer> itemset = new ArrayList<Integer>();
		//奇数为读 偶数为写
		for (TracePO t : traceList) {
			if(itemset.size()==0||t.getMethodName().contains("read")){//itemset为空或者trace为读
				if(t.getMethodName().contains("read")){
				itemset.add(t.getShareMemoryIndex() * 2 + 1);
				}
				else{
					itemset.add(t.getShareMemoryIndex() * 2 );
					}
			}
			else if(itemset.contains(t.getShareMemoryIndex() * 2) == false){
				itemset.add(t.getShareMemoryIndex() * 2 );
			}
			else{
				s.addItemset(itemset);
				itemset = new ArrayList<Integer>();
				itemset.add(t.getShareMemoryIndex() * 2 );
			}
			if(itemset.size()>3){
				s.addItemset(itemset);
				itemset = new ArrayList<Integer>();
			}
		}
		return s;
	}
}
