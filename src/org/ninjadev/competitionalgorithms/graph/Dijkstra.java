package org.ninjadev.competitionalgorithms.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	
	/*
	 * The Node class for Dijkstra.
	 */
	public static class Node implements Comparable<Node>{
		public int dist;
		public int index;
		public int prev;
		public boolean done;
		
		public Node(int index){
			this.dist = Integer.MAX_VALUE;
			this.index = index;
			this.prev = -1;
			this.done = false;
		}
		
		public int compareTo(Node n) {
			return dist-n.dist;
		}
	}
	
	/*
	 * Dijkstra's algorithm for graphs represented by an adjacency matrix. This
	 * implementation is vulnerable to integer overflows.
	 * 
	 * @params
	 * int[][] graph - an n*n adjacency matrix representing the weighted
	 * 				   directional graph. Infinite weights / no edge between
	 * 				   nodes is indicated as Integer.MAX_VALUE.
	 * 
	 * int source    - the index of the source node
	 * 
	 * @return
	 * Returns an array of all the Nodes in the graph (with distance from the
	 * source node in the dist member of the node objects).
	 */
	public static Node[] dijkstra(int[][] graph, int source){
		
		/* declare an array of nodes */	
		Node[] nodes = new Node[graph.length];
		
		/* init the nodes */
		for(int i=0;i<nodes.length;i++){
			nodes[i] = new Node(i);
		}
		
		/* distance from source to source */
		nodes[source].dist  = 0;
		
		/* declare the priority queue to hold the nodes to be inspected */
		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		
		/* fill Q with all the nodes */
		Q.addAll(Arrays.asList(nodes));
		
		/* main loop */
		while(!Q.isEmpty()){
			
			/* get the node nearest to the source */
			Node u = Q.poll();
			u.done = true;
			
			/* if the nearest node is unreachable, we are done */
			if(u.dist == Integer.MAX_VALUE){
				break;
			}
			
			/* for each neighbor v of u */
			for(Node v : nodes){
				
				/* continue with next node if v is marked as done */
				if(v.done){
					continue;
				}
				
				/* continue with next node if v is not actually a neighbor */
				if(graph[u.index][v.index] == Integer.MAX_VALUE){
					continue;
				}
				
				/* calculate shortest distance to v from source through u */
				int alt = u.dist + graph[u.index][v.index]; 
				
				/* if we have found a shorter path from source to v */
				if(alt < v.dist){
					
					/* update the v node */
					v.dist = alt;
					v.prev = u.index;
					
					/* reorder v in the queue */
					Q.remove(v);
					Q.add(v);
				}
			}
			
			/* mark the node as done */
			u.done = true;
		}
		
		/* finally return the array of nodes */
		return nodes;
	}
}
