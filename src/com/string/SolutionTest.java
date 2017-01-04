package com.string;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SolutionTest {
	private static Solution s = new Solution();
	
	@Test
	public void repeatedSubstringPatternTest(){
		Assert.assertEquals(true, s.repeatedSubstringPattern("abcabcabc"));
		Assert.assertEquals(true, s.repeatedSubstringPattern("abab"));
		Assert.assertEquals(false, s.repeatedSubstringPattern("aba"));
		Assert.assertEquals(false, s.repeatedSubstringPattern("a"));
	}
	
	public void countSegmentsTest(){
//		Assert.assertEquals(5, 4);
		Assert.assertEquals(5, s.countSegments("Hello, my name is John"));
		Assert.assertEquals(4, s.countSegments("Hello,   name is John"));
		Assert.assertEquals(2, s.countSegments("Hello,   name    "));
		Assert.assertEquals(0, s.countSegments("       "));
		Assert.assertEquals(0, s.countSegments(""));
	}
	
}
