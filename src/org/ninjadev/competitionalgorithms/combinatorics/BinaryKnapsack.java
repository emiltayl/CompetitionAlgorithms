package org.ninjadev.competitionalgorithms.combinatorics;

public class BinaryKnapsack {
	
	/*
	 * Dynamic programming solution to the binary knapsack problem.
	 * 
	 * @params
	 * int[] values  - the values for items 0..n.
	 * int[] weights - the weights for items 0..n.
	 * int capacity  - the maximum capacity of the knapsack.
	 * 
	 * @return
	 * Returns an int containing the maximum value for the knapsack if filled
	 * optimally.
	 */
	public static int binaryKnapsack(int values[], int[] weights, int capacity){
		
		/* get the number of items for later use */
		int n = values.length;
		
		/* initialize an (n+1)(capacity+1) array for storage during calculation.
		 * c[i][j] holds the maximum value for a knapsack of size j filled with
		 * any of the items from 0..i.*/
		int[][] c = new int[n+1][capacity+1];
		
		/* main loop */
		for(int i=1;i<=n;i++){
			for(int j=1;j<=capacity;j++){
				if(j < weights[i-1]){
					c[i][j] = c[i-1][j];
				}else{
					c[i][j] = Math.max(c[i-1][j], c[i-1][j-weights[i-1]] + values[i-1]);
				}
			}
		}
		
		/* finally return the result */
		return c[n][capacity];
		
		
		/* if we want to see _which_ items were used in the optimal solution we can do this:
		 * 
		 *	   ArrayList<Integer> items = new ArrayList<Integer>();
		 *	   for(int i=0;i<n;i++){
		 *	 	   if(c[i][capacity] != c[i+1][capacity]){
		 *		       items.add(i); 
		 *	       }
		 *	   }
		 * 
		 * items now contains the items that were used in the optimal solution. (TODO: test this code)
		*/
	}

}
