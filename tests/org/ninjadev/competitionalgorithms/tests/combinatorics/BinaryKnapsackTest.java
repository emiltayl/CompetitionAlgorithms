package org.ninjadev.competitionalgorithms.tests.combinatorics;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.combinatorics.BinaryKnapsack;

import junit.framework.TestCase;


public class BinaryKnapsackTest extends TestCase{
	
	@Test
	public void testSmall1(){
		int[] weights = {12,2,1,1,4};
		int[] values  = {4,2,2,1,10};
		int capacity = 15;
		
		int result = BinaryKnapsack.binaryKnapsack(values, weights, capacity);
		
		assertEquals(15, result);
	}
	
	@Test
	public void testSmall2(){
		int[] weights = {2,3,5,4,2,3};
		int[] values  = {7,4,8,6,2,5};
		int capacity = 9;
		
		int result = BinaryKnapsack.binaryKnapsack(values, weights, capacity);
		
		assertEquals(18, result);
	}
	
	@Test
	public void testLarge(){
		int[] weights = {9,  13,153, 50, 15, 68, 27, 39, 23, 52, 11, 32, 24, 48, 73, 42, 43, 22,  7, 18,  4, 30};
		int[] values  = {150,35,200,160, 60, 45, 60, 40, 30, 10, 70, 30, 15, 10, 40, 70, 75, 80, 20, 12, 50, 10};
		int capacity = 400;
		
		int result = BinaryKnapsack.binaryKnapsack(values, weights, capacity);
		
		assertEquals(1030, result);
	}
}
