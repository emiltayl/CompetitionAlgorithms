package org.ninjadev.competitionalgorithms.string;

import java.util.List;
import java.util.LinkedList;

public class LongestCommonSubsequence {
	
	/**
	 * Finds the longest common subsequence for two arrays. Note that if there
	 * are multiple longest common subsequences, only one will be returned by
	 * this function.
	 * Some basic instructions on how to make this function return all the
	 * longest common subsequences are provided, but it will require a thorough
	 * rewrite of the second loop.
	 * 
	 * @param char[] string1 The first array
	 * @param char[] string2 The second array
	 * 
	 * @return A List<Character> with the longest common subsequence
	 */
	public static List<Character> getLongestCommonSubsequence(char[] string1, char[]string2) {
		/* This variable stores the length of the longest common subsequence at
		 * when you are at the i-th position in the first string and the j-th
		 * postition in the second */
		int[][] num = new int[string1.length + 1][string2.length + 1];
		
		for (int i = 1; i < string1.length; i++) {
			for (int j = 1; j < string2.length; j++) {
				if (string1[i-1] == string2[j-1]) {
					/* The i-th character of string 1 and the j-th character
					 * of string 2 are similar, so the length of the longest
					 * common subsequence at this position is one more than
					 * it was at the (i-1)-th and (j-1)-th position */
					num[i][j] = 1 + num[i-1][j-1];
				} else {
					/* The characters are not similar, so the longest subsequence
					 * so far is just the longest length if we go one step
					 * vertically OR horizontally back. */
					num[i][j] = Math.max(num[i-1][j], num[i][j-1]);
				}
			}
		}
		
		int pos1 = string1.length, pos2 = string2.length;
		LinkedList<Character> sequence = new LinkedList<Character>();
		
		/* We start at the back of both strings, and prepend the character to
		 * the result subsequence if both are the same, and move one position
		 * back for both strings. If they are different, we check to see where
		 * we have to move to find the longest subsequence.
		 * 
		 * NOTE! If we want to find *all* the longest subsequences, we need a
		 * list of lists that contain all the longest subsequences.*/
		while (pos1 > 0 && pos2 > 0) {
			if (string1[pos1 - 1] == string2[pos2 - 1]) {
				sequence.addFirst(string1[pos1 - 1]);
				pos1--;
				pos2--;
			} else if (num[pos1][pos2-1] > num[pos1-1][pos2]) {
				/* NOTE! If we want to find *all* the longest subsequences, we
				 *  need to check both num[pos1][pos2-1] >= num[pos1-1][pos2]
				 * AND num[pos1][pos2-1] <= num[pos1-1][pos2]
				 * and act accordingly. */
				pos2--;
			} else {
				pos1--;
			}
		}
		
		return sequence;
	}
}
