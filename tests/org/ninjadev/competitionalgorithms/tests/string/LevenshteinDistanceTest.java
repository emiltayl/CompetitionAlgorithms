package org.ninjadev.competitionalgorithms.tests.string;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.string.LevenshteinDistance;

import junit.framework.TestCase;


public class LevenshteinDistanceTest extends TestCase{
	
	@Test
	public void testEmptyString(){
		assertEquals(0, LevenshteinDistance.levenshteinDistance("", ""));
		assertEquals(5, LevenshteinDistance.levenshteinDistance("hello", ""));
		assertEquals(5, LevenshteinDistance.levenshteinDistance("", "world"));
	}
	
	@Test
	public void testEqualStrings(){
		assertEquals(0, LevenshteinDistance.levenshteinDistance("hello world!", "hello world!"));
	}
	
	@Test
	public void testLongStrings(){
		assertEquals(11, LevenshteinDistance.levenshteinDistance("hello world!", "apple"));
		assertEquals(7,  LevenshteinDistance.levenshteinDistance("This is a very long string", "This is a very much longer string"));
	}
}
