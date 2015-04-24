package com.ccnu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.ccnu.algo.AlgoKit;
import com.ccnu.algo.datastructures.Sequence;
import com.ccnu.algo.datastructures.SequenceDatabase;
import com.ccnu.algo.datastructures.SequentialPattern;
import com.ccnu.algo.datastructures.SequentialPatterns;
import com.ccnu.dao.SequenceDao;
import com.ccnu.util.DataToSequence;
import com.ccnu.util.SequencesUtil;


public class Main {
	public static AlgoKit algoRun=new AlgoKit();


	public static void main(String[] args) throws Exception {
		Main m=new Main();
//		List<SequentialPattern> runFSGP = m.runFSGP(0.5, 0.7);
//		List<SequentialPattern> runFEAT = m.runFEAT(0.5, 0.7);	
//		List<SequentialPattern> runPrefixSpan = m.runPrefixSpan(1, 0.7);
		List<SequentialPattern> runTSP_nonClosed = m.runTSP_nonClosed(0.9, 0.5);
		List<SequentialPattern> result=new ArrayList<SequentialPattern>();
		result.addAll(runTSP_nonClosed);
//		result.addAll(runPrefixSpan);
//		result.addAll(runFEAT);
//		result.addAll(runFSGP);
		m.showResult(result);
	}
	
	
	public List<SequentialPattern> runPrefixSpan(double t_min_support,double f_min_support) throws Exception {
		SequenceDatabase trueSequence=DataToSequence.getTrueSequenceFromDB();
		SequenceDatabase falseSequence=DataToSequence.getFalseSequenceFromDB();
		List<SequentialPattern> runPrefixSpanTrue = algoRun.runPrefixSpan(trueSequence,(int) (Math.ceil(t_min_support*trueSequence.size()))).toSequentialPatternList();
		List<SequentialPattern> runPrefixSpanFalse=algoRun.runPrefixSpan(falseSequence,(int) (Math.ceil(f_min_support*falseSequence.size()))).toSequentialPatternList();
		
		SequencesUtil.sub(runPrefixSpanTrue,runPrefixSpanFalse);
		List<SequentialPattern> result=runPrefixSpanFalse;
		return result;
	}
	
	public List<SequentialPattern> runTSP_nonClosed(double t_min_support,double f_min_support) throws Exception {
		SequenceDatabase trueSequence=DataToSequence.getTrueSequenceFromDB();
		SequenceDatabase falseSequence=DataToSequence.getFalseSequenceFromDB();
		List<SequentialPattern> runTSPTrue =algoRun.runTSP_nonClosed(trueSequence,(int) (Math.ceil(t_min_support*trueSequence.size())));
		List<SequentialPattern> runTSPFalse=algoRun.runTSP_nonClosed(falseSequence,(int) (Math.ceil(f_min_support*falseSequence.size())));
		
		SequencesUtil.sub(runTSPTrue,runTSPFalse);
		List<SequentialPattern> result=runTSPFalse;
		return result;
	}
	
	
	public List<SequentialPattern> runFSGP(double t_min_support,double f_min_support) throws Exception {
		SequenceDatabase trueSequence=DataToSequence.getTrueSequenceFromDB();
		SequenceDatabase falseSequence=DataToSequence.getFalseSequenceFromDB();
		List<SequentialPattern> runFSGPTrue = algoRun.runFSGP(trueSequence,t_min_support);
		List<SequentialPattern> runFSGPFalse=algoRun.runFSGP(falseSequence,f_min_support);
		SequencesUtil.sub(runFSGPTrue,runFSGPFalse);
		List<SequentialPattern> result=runFSGPFalse;
		return result;
	}
	
	
	public List<SequentialPattern> runFEAT(double t_min_support,double f_min_support) throws Exception {
		SequenceDatabase trueSequence=DataToSequence.getTrueSequenceFromDB();
		SequenceDatabase falseSequence=DataToSequence.getFalseSequenceFromDB();
		List<SequentialPattern> runFEATTrue = algoRun.runFEAT(trueSequence,t_min_support);
		List<SequentialPattern> runFEATFasle=algoRun.runFEAT(falseSequence,f_min_support);
		SequencesUtil.sub(runFEATTrue,runFEATFasle);
		List<SequentialPattern> result=runFEATFasle;
		return result;
	}
	
	public List<String> getTrueSeqs() throws Exception{
		SequenceDatabase trueSequence=DataToSequence.getTrueSequenceFromDB();
		return trueSequence.toStringList();
	}
	public List<String> getFalseSeqs() throws Exception{
		SequenceDatabase trueSequence=DataToSequence.getFalseSequenceFromDB();
		return trueSequence.toStringList();
	}
	public void  showResult(List<SequentialPattern> result) throws Exception{
		System.out.println("----RESULT----");	
		for (SequentialPattern pattern : result) {
			System.out.print(pattern + " support : "
					+ pattern.getAbsoluteSupport() + " sequence ids:");
			for (Integer sequenceID : pattern.getSequenceIDs()) {
				System.out.print(" " + sequenceID);
			}
			System.out.println();	
		}	
	}
	

}
