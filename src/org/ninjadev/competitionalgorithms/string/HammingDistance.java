package org.ninjadev.competitionalgorithms.string;

public class HammingDistance {
	/*
	 * Hamming distance between two strings.
	 * 
	 * @params
	 * String s - the string to measure distance from.
	 * String t - the string to measure distance to.
	 * 
	 * @return
	 * An int holding the Hamming distance between s and t.
	 */
	public static int hammingDistance(String s, String t){
		
		/* Hamming distance is only defined for strings of equal length */
		assert s.length() == t.length();
		
		/* start the distance count at 0 */
		int distance = 0;
		
		/* count the number of positions at which the corresponding symbols differ */
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) != t.charAt(i)){
				distance++;
			}
		}
		
		/* finally return the Hamming distance */
		return distance;
	}
}
