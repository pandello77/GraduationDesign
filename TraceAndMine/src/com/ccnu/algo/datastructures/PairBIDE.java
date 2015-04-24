package com.ccnu.algo.datastructures;



public class PairBIDE extends Pair{
	
	// indicate if this represents the item appearing 
	// in an itemset that is cut at the right or not (a prefix)
	private final boolean prefix; 
	
	/**
	 * Constructor
	 * @param postfix indicate if this is the case of an item appearing
	 *  in an itemset that is cut at the left because of a projection
	 *  @param prefix indicate if this is the case of an item appearing
	 *  in an itemset that is cut at the right because of a projection
	 * @param item the item
	 */
	PairBIDE(boolean prefix, boolean postfix, Integer item){
		super(postfix, item);
		this.prefix  = prefix;
	}
	
	/**
	 * Check if two pairs are equal (same item and both appears in a postfix or not and prefix or not).
	 * @return true if equals.
	 */
	public boolean equals(Object object){
		PairBIDE paire = (PairBIDE) object;
		if((paire.postfix == this.postfix) 
				&& (paire.prefix == this.prefix)
				&& (paire.item.equals(this.item))){
			return true;
		}
		return false;
	}
	
	/**
	 * Method to calculate an hashcode (because pairs are stored in a map).
	 */
	public int hashCode()
	{// Ex: 127333,P,X,1  127333,N,Z,2
		// transform it into a string
		StringBuilder r = new StringBuilder();
		r.append((postfix ? 'P' : 'N')); // the letters here have no meanings. they are just used for the hashcode
		r.append((prefix ? 'X' : 'Z')); // the letters here have no meanings. they are just used for the hashcode
		r.append(item);
		// then use the hashcode method from the string class
		return r.toString().hashCode();
	}
	
	/**
	 * Check if this is the case of the item appearing in a prefix
	 * @return true if this is the case.
	 */
	public boolean isPrefix() {
		return prefix;
	}
}