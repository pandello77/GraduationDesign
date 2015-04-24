package com.ccnu.algo;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.ccnu.algo.datastructures.*;


public class AlgoKit {



	public SequentialPatterns runPrefixSpan(SequenceDatabase sequenceDatabase,int support)
			throws Exception {
		AlgoPrefixSpan algo = new AlgoPrefixSpan();// ok
	
		SequentialPatterns patterns = algo.runAlgorithm(sequenceDatabase, null,
				support);

		algo.printStatistics(sequenceDatabase.size());
		return patterns;
//		patterns.printFrequentPatterns(sequenceDatabase.size(),
//				showSequenceIdentifiers);
		

	}

	
	public List<SequentialPattern> runFEAT(SequenceDatabase sequenceDatabase,double minsupPercent) throws Exception {
		AlgoFEAT algo = new AlgoFEAT();// ok

		List<SequentialPattern> patterns = algo.runAlgorithm(sequenceDatabase,
				 minsupPercent);

		algo.printStatistics(sequenceDatabase.size());
		System.out.println(" == PATTERNS ==");
		for (SequentialPattern pattern : patterns) {
			System.out.print(pattern + " support : "
					+ pattern.getAbsoluteSupport() + " sequence ids:");
			for (Integer sequenceID : pattern.getSequenceIDs()) {
				System.out.print(" " + sequenceID);
			}
			System.out.println();
		}
		return patterns;
	}

	public List<SequentialPattern> runFSGP(SequenceDatabase sequenceDatabase,double minsupPercent) throws Exception {
		AlgoFSGP algo = new AlgoFSGP();// ok
		boolean performPruning = true;// to activate pruning of search space
		List<SequentialPattern> patterns = algo.runAlgorithm(sequenceDatabase,minsupPercent,performPruning);

		algo.printStatistics(sequenceDatabase.size());
		System.out.println(" == PATTERNS ==");
		for (SequentialPattern pattern : patterns) {
			System.out.print(pattern + " support : "
					+ pattern.getAbsoluteSupport() + " sequence ids:");
			for (Integer sequenceID : pattern.getSequenceIDs()) {
				System.out.print(" " + sequenceID);
			}
			System.out.println();
		}
		return patterns;
	}
	public List<SequentialPattern> runTSP_nonClosed(SequenceDatabase sequenceDatabase,int support) throws Exception {
		AlgoTSP_nonClosed algo = new AlgoTSP_nonClosed();// ok
		PriorityQueue<SequentialPattern> patterns=algo.runAlgorithm(sequenceDatabase,support);
		algo.printStatistics(sequenceDatabase.size());
		int id=0;
		System.out.println(" == PATTERNS ==");
		for (SequentialPattern pattern : patterns) {
			
			System.out.print("id"+id+""+pattern + " support : "
					+ pattern.getAbsoluteSupport() + " sequence ids:");
			for (Integer sequenceID : pattern.getSequenceIDs()) {
				System.out.print(" " + sequenceID);
			}
			id++;
			System.out.println();
		}
		
		int size=patterns.size();
		SequentialPattern[] a=new SequentialPattern[size];
		List<SequentialPattern> sequentialList =new LinkedList<SequentialPattern>(Arrays.asList(patterns.toArray(a)));
		return sequentialList;
//		return patterns;
	}

}
