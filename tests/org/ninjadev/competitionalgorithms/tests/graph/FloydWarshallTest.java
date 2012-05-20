package org.ninjadev.competitionalgorithms.tests.graph;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.graph.FloydWarshall;

import junit.framework.TestCase;


public class FloydWarshallTest extends TestCase {
	
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
		
		int[][] paths = FloydWarshall.floydWarshall(graph);
		
		for(int k=0;k<graph.length;k++){
			for(int j=0;j<graph.length;j++){
				assertEquals(i,paths[k][j]);
			}
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
		
		int[][] paths = FloydWarshall.floydWarshall(graph);
		
		for(int k=0;k<graph.length;k++){
			for(int j=0;j<graph.length;j++){
				assertEquals(k==j?0:1,paths[k][j]);
			}
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
		
		int[][] expected = {
				{0,  2,  4,  10, 12, 8,  13}, 
				{2,  0,  3,  9,  11, 6,  12}, 
				{4,  3,  0,  6,  8,  9,  9}, 
				{10, 9,  6,  0,  2,  12, 3}, 
				{12, 11, 8,  2,  0,  14, 5}, 
				{8,  6,  9,  12, 14, 0,  9}, 
				{13, 12, 9,  3,  5,  9,  0}
				};
		
		int[][] paths = FloydWarshall.floydWarshall(graph);
		
		for(int k=0;k<graph.length;k++){
			for(int j=0;j<graph.length;j++){
				assertEquals(expected[k][j],paths[k][j]);
			}
		}
	}
}