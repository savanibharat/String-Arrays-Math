package com.arithmetic;

import java.util.List;



import com.util.arrays.ArrayUtils;

/**
 * The Class Mean.
 */
public class Mean {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println(Mean.meanDouble(new double[] { 1d, 2d, 3d, 4d, 5d,
				6d }));
	}

	/**
	 * Mean double.
	 *
	 * @param list
	 *            the list
	 * @return the double
	 */
	public static double meanDouble(List<Double> list) {

		return Summation.sumDouble(list) / list.size();
	}

	/**
	 * Mean double.
	 *
	 * @param arr
	 *            the arr
	 * @return the double
	 */
	public static double meanDouble(double[] arr) {
		return Summation.sumDouble(ArrayUtils.toList(arr));
	}

	/**
	 * Mean long.
	 *
	 * @param list
	 *            the list
	 * @return the long
	 */
	public static long meanLong(List<Long> list) {
		return Summation.sumLong(list) / list.size();
	}

	/**
	 * Mean long.
	 *
	 * @param arr
	 *            the arr
	 * @return the long
	 */
	public static long meanLong(long[] arr) {
		return Summation.sumLong(ArrayUtils.toList(arr));
	}

	/**
	 * Mean float.
	 *
	 * @param list
	 *            the list
	 * @return the float
	 */
	public static float meanFloat(List<Float> list) {
		return Summation.sumFloat(list) / list.size();
	}

	/**
	 * Mean float.
	 *
	 * @param arr
	 *            the arr
	 * @return the float
	 */
	public static float meanFloat(float[] arr) {
		return Summation.sumFloat(ArrayUtils.toList(arr));
	}

	/**
	 * Mean integer.
	 *
	 * @param list
	 *            the list
	 * @return the int
	 */
	public static int meanInteger(List<Integer> list) {
		return Summation.sumInteger(list) / list.size();
	}

	/**
	 * Mean integer.
	 *
	 * @param arr
	 *            the arr
	 * @return the int
	 */
	public static int meanInteger(int[] arr) {
		return Summation.sumInteger(ArrayUtils.toList(arr));
	}

}
