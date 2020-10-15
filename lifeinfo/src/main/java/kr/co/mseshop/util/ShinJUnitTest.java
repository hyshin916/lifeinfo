package kr.co.mseshop.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShinJUnitTest {
	
	
	@Test
	public void test() {
		ShinJUnit sj = new ShinJUnit();
		boolean result = false;
		boolean a = sj.test(3);
		assertEquals(result, a);
	}
}
