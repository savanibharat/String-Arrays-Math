package com.arithmetic;

import java.util.List;

public class Summation {

	/*
	 * @param list the list
	 * 
	 * @return the double
	 */
	public static double sumDouble(List<Double> list) {

		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	/**
	 * Sum long.
	 *
	 * @param list
	 *            the list
	 * @return the long
	 */
	public static long sumLong(List<Long> list) {

		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	public static float sumFloat(List<Float> list) {

		float sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	/**
	 * Sum integer.
	 *
	 * @param list
	 *            the list
	 * @return the int
	 */
	public static int sumInteger(List<Integer> list) {

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

}
