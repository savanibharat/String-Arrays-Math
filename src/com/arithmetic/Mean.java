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
		
		//float, long, int, double
		float[] f={1f, 2f, 3f, 4f, 5f,6f };
		System.out.println(Mean.meanFloat(f));
		
		long[] l={1,2,3,4,5,6};
		System.out.println(Mean.meanLong(l));
		
		int[] i={1,2,3,4,5,6};
		System.out.println(Mean.meanInteger(i));
		
		double[] d={ 1d, 2d, 3d, 4d, 5d, 6d };
		System.out.println(Mean.meanDouble(d));
		
		//System.out.println(Mean.meanDouble(new double[] { 1d, 2d, 3d, 4d, 5d, 6d }));
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
		return Summation.sumDouble(ArrayUtils.toList(arr))/arr.length;
	}

	/**
	 * Mean long.
	 *
	 * @param list
	 *            the list
	 * @return the long
	 */
	public static double meanLong(List<Long> list) {
		return (double) Summation.sumLong(list) / list.size();
	}

	/**
	 * Mean long.
	 *
	 * @param arr
	 *            the arr
	 * @return the long
	 */
	public static double meanLong(long[] arr) {
		return (double) Summation.sumLong(ArrayUtils.toList(arr))/arr.length;
	}

	/**
	 * Mean float.
	 *
	 * @param list
	 *            the list
	 * @return the float
	 */
	public static double meanFloat(List<Float> list) {
		return (double) Summation.sumFloat(list) / list.size();
	}

	/**
	 * Mean float.
	 *
	 * @param arr
	 *            the arr
	 * @return the float
	 */
	public static double meanFloat(float[] arr) {
		return (double) Summation.sumFloat(ArrayUtils.toList(arr))/arr.length;
	}

	/**
	 * Mean integer.
	 *
	 * @param list
	 *            the list
	 * @return the int
	 */
	public static double meanInteger(List<Integer> list) {
		return (double) Summation.sumInteger(list) / list.size();
	}

	/**
	 * Mean integer.
	 *
	 * @param arr
	 *            the arr
	 * @return the int
	 */
	public static double meanInteger(int[] arr) {
		return (double) Summation.sumInteger(ArrayUtils.toList(arr))/arr.length;
	}

}
