package org.ninjadev.competitionalgorithms.tests.string;

import org.junit.Test;
import org.ninjadev.competitionalgorithms.string.HammingDistance;

import junit.framework.TestCase;

public class HammingDistanceTest extends TestCase {

	@Test
	public void testEmptyString(){
		assertEquals(0, HammingDistance.hammingDistance("", ""));
	}
	
	@Test
	public void testEqualStrings(){
		assertEquals(0, HammingDistance.hammingDistance("hello world!", "hello world!"));
	}
	
	@Test
	public void testUnequalStrings(){
		assertEquals(1, HammingDistance.hammingDistance("123451234", "123441234"));
		assertEquals(10,  HammingDistance.hammingDistance("aaaaaaaaaa", "bbbbbbbbbb"));
	}
}
