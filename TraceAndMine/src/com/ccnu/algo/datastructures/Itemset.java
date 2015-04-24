package com.ccnu.algo.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Itemset{

	
	private final List<Integer> items = new ArrayList<Integer>(); 
	
	public Itemset(Integer item){
		addItem(item);
	}
	
	
	public Itemset(){
	}

	
	public void addItem(Integer value){
			items.add(value);
	}
	
	
	public List<Integer> getItems(){
		return items;
	}
	
	
	public Integer get(int index){
		return items.get(index);
	}

	
	public String toString(){
		StringBuilder r = new StringBuilder ();
		for(Integer item : items){
			r.append(item.toString());
			r.append(' ');
		}
		return r.toString();
	}
	

	public int size(){
		return items.size();
	}

	/**
	 * This methods makes a copy of this itemset but without
	 * items having a support lower than minsup
	 * @param mapSequenceID a map indicating the support of each item. key: item  value: support
	 * @param relativeMinsup the support expressed as a percentage
	 * @return the new itemset
	 */
	public Itemset cloneItemSetMinusItems(Map<Integer, Set<Integer>> mapSequenceID, double relativeMinsup) {
		Itemset itemset = new Itemset();
		for(Integer item : items){
			if(mapSequenceID.get(item).size() >= relativeMinsup){
				itemset.addItem(item);
			}
		}
		return itemset;
	}
	
	
	public Itemset cloneItemSet(){
		Itemset itemset = new Itemset();
		itemset.getItems().addAll(items);
		return itemset;
	}
	
	
	public boolean containsAll(Itemset itemset2){
		// we will use this variable to remember where we are in this itemset
		int i = 0;
		
		// for each item in itemset2, we will try to find it in this itemset
		for(Integer item : itemset2.getItems()){
			boolean found = false; // flag to remember if we have find the item
			
			// we search in this itemset starting from the current position i
			while(found == false && i < size()){
				// if we found the current item from itemset2, we stop searching
				if(get(i).equals(item)){
					found = true;
				}// if the current item in this itemset is larger than 
				// the current item from itemset2, we return false
				// because the itemsets are assumed to be lexically ordered.
				else if(get(i) > item){
					return false;
				}
				
				i++; // continue searching from position  i++
			}
			// if the item was not found in the previous loop, return false
			if(!found){
				return false;
			}
		}
		return true; // if all items were found, return true
	}
	@Override
	public boolean equals(Object o) {
			if(o == this){
				return true;
			}
			if(o == null)         
				   return false;
			if( !(o instanceof Itemset ))
				   return false;
			Itemset i=(Itemset)o;
			if(this.toString().contains(i.toString()))
				return true;
			else
				return false;
	}
	
			
}
