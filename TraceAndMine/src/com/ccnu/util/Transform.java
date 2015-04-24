package com.ccnu.util;

import java.util.ArrayList;
import java.util.List;
import com.ccnu.po.TracePO;
public class Transform {
	public static 
	List<List<String>> TracePOMatrix2StringMatrix(List<List<TracePO>> tMatrix){
		List<List<String>> result = new ArrayList<List<String>>();
		int len=tMatrix.size();
		for(int i=0;i<len;i++){
			int width=tMatrix.get(i).size();
			List<String> oneResult=new ArrayList<String>();
			for(int j=0;j<width;j++){
				String temp;
				if(tMatrix.get(i).get(j).getMethodName().contains("read")){
					temp="R["+tMatrix.get(i).get(j).getShareMemoryIndex()+"]"+tMatrix.get(i).get(j).getShareMemoryValue();
					oneResult.add(temp);
					}
				else if(tMatrix.get(i).get(j).getMethodName().contains("write")){
					temp="W["+tMatrix.get(i).get(j).getShareMemoryIndex()+"]"+tMatrix.get(i).get(j).getShareMemoryValue();
					oneResult.add(temp);
				}
				else;
			}
			result.add(oneResult);
		}
		return result;
	}

}
