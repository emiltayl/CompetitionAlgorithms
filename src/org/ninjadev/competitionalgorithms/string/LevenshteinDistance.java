package org.ninjadev.competitionalgorithms.string;

public class LevenshteinDistance {

	/*
	 * Levenshtein distance between two strings.
	 * 
	 * @params
	 * String s - the string to measure distance from.
	 * String t - the string to measure distance to.
	 * 
	 * @return
	 * An int holding the Levenshtein distance between s and t.
	 */
	public static int levenshteinDistance(String s, String t){
		
		/* store the lengths of the strings for later use */
		int m = s.length();
		int n = t.length();
		
		/* initialize an (m+1)(n+1) array for storing lengths during calculation */
		int[][] dist = new int[m+1][n+1];
		
		
		/* source prefixes can be transformed into empty string by dropping all characters */
		for(int i=1;i<=m;i++){
			dist[i][0] = i;
		}
		
		/* target prefixes can be reached from empty source prefix by inserting all characters */
		for(int j=1;j<=n;j++){
			dist[0][j] = j;
		}
		
		/* main loop */
		for(int j=1;j<=n;j++){
			for(int i=1;i<=m;i++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dist[i][j] = dist[i-1][j-1];
				}else{
					dist[i][j] = 1 +
						Math.min(
									dist[i-1][ j ], //a deletion
						Math.min(   dist[ i ][j-1], //an insertion
									dist[i-1][j-1]  //a substitution
						));
				}
			}
		}
		
		/* finally return the Levenshtein distance */
		return dist[m][n];
	}
}
