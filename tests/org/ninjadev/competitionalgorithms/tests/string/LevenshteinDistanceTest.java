package org.ninjadev.competitionalgorithms.tests.string;

import org.ninjadev.competitionalgorithms.string.LevenshteinDistance;

import junit.framework.TestCase;


public class LevenshteinDistanceTest extends TestCase{

	public static void main(String[]args){
		LevenshteinDistanceTest.testEmptyString();	
		LevenshteinDistanceTest.testEqualStrings();	
		LevenshteinDistanceTest.testLongStrings();	
	}
	
	public static void testEmptyString(){
		assertEquals(0, LevenshteinDistance.levenshteinDistance("", ""));
		assertEquals(5, LevenshteinDistance.levenshteinDistance("hello", ""));
		assertEquals(5, LevenshteinDistance.levenshteinDistance("", "world"));
	}
	
	public static void testEqualStrings(){
		assertEquals(0, LevenshteinDistance.levenshteinDistance("hello world!", "hello world!"));
	}
	
	public static void testLongStrings(){
		assertEquals(11, LevenshteinDistance.levenshteinDistance("hello world!", "apple"));
		assertEquals(7,  LevenshteinDistance.levenshteinDistance("This is a very long string", "This is a very much longer string"));
	}
}
