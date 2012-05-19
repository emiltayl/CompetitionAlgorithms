package org.ninjadev.competitionalgorithms.graph;

public class FloydWarshall {
	
	/*
	 * Floyd-Warshall for graphs represented by an adjacency matrix.
	 * 
	 * @params
	 * int[][] graph - an n*n adjacency matrix representing the weighted
	 * 				   directional graph. Infinite weights / no edge between
	 * 				   nodes is indicated as Integer.MAX_VALUE.
	 * 
	 * @return
	 * An array containing the length of the shortest path from node i to node
	 * j. 
	 */
	public static int[][] floydWarshall(int[][] graph){
		
		/* get the number of nodes for convenience */
		int n = graph.length;
		
		/* deep clone the graph to a new array, to prevent destruction of the
		 * graph. If we don't care about destroying the graph, we can just
		 * assign graph to path by reference instead:
		 *  int[][] path = graph;
		 *  */
		int[][] path = graph.clone();
		for(int i=0;i<n;i++){
			path[i] = graph[i].clone();
		}
		
		/* main loop */
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					
					/* calculate path length if we use node k */
					int alt = path[i][k]+path[k][j];
					
					/* guard against integer overflows */
					alt=((long)path[i][k])+path[k][j]==alt?alt:Integer.MAX_VALUE;
						
					/* consider adding the kth node to the shortest path from i to j */
					path[i][j] = Math.min(path[i][j], alt);
				}
			}
		}
		
		/* finally return the array with shortest paths from node i to node j */
		return path;
	}

}
