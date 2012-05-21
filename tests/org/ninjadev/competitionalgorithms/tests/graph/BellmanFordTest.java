package org.ninjadev.competitionalgorithms.tests.graph;

import junit.framework.TestCase;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.graph.BellmanFord;
import org.ninjadev.competitionalgorithms.graph.BellmanFord.Edge;


public class BellmanFordTest extends TestCase {
	
	@Test
	public void testEmptyGraph(){
		int n = 0;
		int source = 0;
		Edge[] edges = new Edge[0];
		
		int[] dist = BellmanFord.bellmanFord(edges, n, source);
		
		assertEquals(0, dist.length);
	}
	
	@Test
	public void testMonoweightedGraph(){
		int n = 8;
		int source = 0;
		Edge[] edges = new Edge[n*n];
		
		for(int u=0;u<n;u++){
			for(int v=0;v<n;v++){
				edges[u*n+v] = new Edge(u,v,1);
			}
		}
		
		int[] dist = BellmanFord.bellmanFord(edges, n, source);
		
		for(int i=0;n<dist.length;n++){
			assertEquals(i == source ? 0 : 1, dist[i]);
		}
	}
	
	@Test
	public void testHandMadeGraph(){
		int n = 7;
		int source = 1;
		Edge[] edges = {
				new Edge(0,1,2),
				new Edge(1,0,2),
				new Edge(1,2,3),
				new Edge(1,5,6),
				new Edge(2,0,4),
				new Edge(2,1,3),
				new Edge(2,3,6),
				new Edge(3,2,6),
				new Edge(3,4,2),
				new Edge(3,6,3),
				new Edge(4,3,2),
				new Edge(4,6,5),
				new Edge(5,1,6),
				new Edge(5,6,9),
				new Edge(6,3,3),
				new Edge(6,4,5),
				new Edge(6,5,9)
		};
	
		int[] expectedDistance = { 2, 0, 3, 9, 11, 6, 12};
		
		int[] dist = BellmanFord.bellmanFord(edges, n, source);
		
		for(int i=0;n<dist.length;n++){
			assertEquals( expectedDistance[i], dist[i]);
		}
	}
	
	@Test
	public void testNegativeCycle(){
		int n = 3;
		int source = 1;
		Edge[] edges = {
				new Edge(0,1,-1),
				new Edge(1,2,-1),
				new Edge(2,0,-1)
		};
	
		
		int[] dist = BellmanFord.bellmanFord(edges, n, source);
		
		assertEquals(null, dist);
	}
}
