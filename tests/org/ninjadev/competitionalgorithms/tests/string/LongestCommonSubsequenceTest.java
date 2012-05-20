package org.ninjadev.competitionalgorithms.tests.string;

import org.ninjadev.competitionalgorithms.string.LongestCommonSubsequence;

import org.junit.Test;
import junit.framework.TestCase;

public class LongestCommonSubsequenceTest extends TestCase {
	@Test
	public static void testLongestCommonSubSequence() {
		assertTrue("[B, E, G, C, E, B]".equals(LongestCommonSubsequence.getLongestCommonSubsequence("ACBDEGCEDBG".toCharArray(), "BEGCFEUBK".toCharArray()).toString()));
	}
	
	@Test
	public static void testEmptyCommonSubSequence() {
		assertTrue("[]".equals(LongestCommonSubsequence.getLongestCommonSubsequence("ABC".toCharArray(), "DEF".toCharArray()).toString()));
	}
	
	@Test
	public static void testSameString() {
		assertTrue("[A, B, C]".equals(LongestCommonSubsequence.getLongestCommonSubsequence("ABC".toCharArray(), "ABC".toCharArray()).toString()));
	}
}
