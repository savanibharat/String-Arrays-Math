package com.util.arrays.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.util.arrays.ArrayUtils;

public class ArrayTest {

	int[] a;
	static int INDEX_NOT_FOUND = -1;

	@Before
	public void setup() {
		a = new int[] { 4, 6, 5, 3, 6, 3, 5, 2 };
	}

	@Test
	public void testContains() {
		Assert.assertEquals(INDEX_NOT_FOUND, ArrayUtils.indexOf(a, 8));
	}

	@After
	public void afterOperations(){
		a=null;
	}
}
