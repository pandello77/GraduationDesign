package com.ccnu.util;

import java.util.ArrayList;
import java.util.List;

import com.ccnu.algo.datastructures.Itemset;
import com.ccnu.algo.datastructures.SequentialPattern;

public class SequencesUtil {

	public static List<SequentialPattern> sub(List<SequentialPattern> trueList,
			List<SequentialPattern> fasleList) {
		List<SequentialPattern> result=new ArrayList<SequentialPattern>();
		for(int i=0;i<trueList.size();i++){
			for(int j=0;j<fasleList.size();j++){
				try {
					if(SequenceContain(fasleList.get(j),trueList.get(i))){
						fasleList.remove(j);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	public static boolean SequenceContain(SequentialPattern father,SequentialPattern sub){
		if(father.size()<sub.size())
			return false;
		int j=0;
		int flag=0;
		for(int i=0;i<sub.size();i++){
			for(;j<father.size();j++){
				if(ItemsetContain(father.get(j),sub.get(i))){
					flag++;
					break;
				}
			}
		}
		if(flag==sub.size())
			return true;
		else
			return false;
	}
	
	public static boolean ItemsetContain(Itemset father,Itemset sub){
		if(father.size()<sub.size())
			return false;
		for(Integer i:sub.getItems()){
		if(!father.getItems().contains(i))
			return false;
		}
		return true;
		
	}
	
public static boolean validation(List<SequentialPattern> list,SequentialPattern s){
	for(int i=0;i<list.size();i++){
		if(SequenceContain(list.get(i),s))
			return true;
	}
	return false;
	}

}
