package com.util.strings.test;

import junit.framework.Assert;

import org.junit.Test;

import com.util.strings.StringUtils;

public class StringTest {

	final String EMPTY_STRING = "";
	final String STRING_VALUE = "STRING_VALUE";
	final String NULL_STRING = null;
	final boolean FALSE_VALUE = false;
	final boolean TRUE_VALUE = true;
	final String STRING_ARRAY_EMPTY[]={};
	final String STRING_ARRAY_NULL[]=null;
	final String STRING_ARRAY[]={"Jack","George","Tropicana","Juice"};
	
	
	@Test
	public void hasLengthForEmptyString() {
		Assert.assertEquals(FALSE_VALUE, StringUtils.hasLength(EMPTY_STRING));
	}

	@Test
	public void hasLengthForNullString() {
		Assert.assertEquals(FALSE_VALUE, StringUtils.hasLength(NULL_STRING));
	}

	@Test
	public void hasLengthForStringValue() {
		Assert.assertEquals(TRUE_VALUE, StringUtils.hasLength(STRING_VALUE));
	}

	@Test
	public void resolveNullStringForEmptyString() {
		Assert.assertEquals(EMPTY_STRING,
				StringUtils.resolveNullString(EMPTY_STRING));
	}

	@Test
	public void resolveNullStringForNullString() {
		Assert.assertEquals(EMPTY_STRING,
				StringUtils.resolveNullString(NULL_STRING));
	}

	@Test
	public void resolveNullStringForStringValue() {
		Assert.assertEquals(STRING_VALUE,
				StringUtils.resolveNullString(STRING_VALUE));
	}

}
