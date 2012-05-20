package org.ninjadev.competitionalgorithms.tests.graph;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.graph.Dijkstra;
import org.ninjadev.competitionalgorithms.graph.Dijkstra.Node;

import junit.framework.TestCase;


public class DijkstraTest extends TestCase {
	
	/* short form for "infinity" */
	static final int i = Integer.MAX_VALUE;
	
	@Test
	public void testEmptyGraph(){
		int[][] graph = {
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i},
				{i,i,i,i,i,i,i,i}
				};
		
		int source = 0;
		Node[] nodes = Dijkstra.dijkstra(graph, source);
		
		for(Node n : nodes){
			assertEquals(n.index == source ? 0 : i, n.dist);
		}
	}
	
	@Test
	public void testMonoweightedGraph(){
		int[][] graph = {
				{0,1,1,1,1,1,1,1},
				{1,0,1,1,1,1,1,1},
				{1,1,0,1,1,1,1,1},
				{1,1,1,0,1,1,1,1},
				{1,1,1,1,0,1,1,1},
				{1,1,1,1,1,0,1,1},
				{1,1,1,1,1,1,0,1},
				{1,1,1,1,1,1,1,0}
				};
		
		int source = 0;
		Node[] nodes = Dijkstra.dijkstra(graph, source);
		
		for(Node n : nodes){
			assertEquals(n.index == source ? 0 : 1, n.dist);
		}
	}
	
	@Test
	public void testHandMadeGraph(){
		int[][] graph = {
				{0,2,4,i,i,i,i},
				{2,0,3,i,i,6,i},
				{4,3,0,6,i,i,i},
				{i,i,6,0,2,i,3},
				{i,i,i,2,0,i,5},
				{i,6,i,i,i,0,9},
				{i,i,i,3,5,9,0}
				};
		
		int source = 1;
		
		Node[] nodes = Dijkstra.dijkstra(graph, source);
		
		int[] expectedDistance = { 2, 0, 3, 9, 11, 6, 12};
		
		for(Node n : nodes){
			assertEquals(expectedDistance[n.index], n.dist);
		}
	}
}
		
