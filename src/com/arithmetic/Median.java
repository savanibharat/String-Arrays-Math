package com.arithmetic;

import java.util.Collections;
import java.util.List;

import com.util.arrays.ArrayUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Median.
 */
public class Median {

	/**
	 * Median double.
	 *
	 * @param list the list
	 * @return the double
	 */
	public static double medianDouble(List<Double> list) {
		if (list == null || list.size() == 0) {
			return Double.MIN_VALUE;
		}
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListDouble(list);
		}
		return oddListDouble(list);
	}

	/**
	 * Median double.
	 *
	 * @param a the a
	 * @return the double
	 */
	public static double medianDouble(double[] a) {
		if (a == null || a.length == 0) {
			return Double.MIN_VALUE;
		}
		
		List<Double> list = ArrayUtils.toList(a);
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListDouble(list);
		}
		return oddListDouble(list);
	}

	/**
	 * Even list double.
	 *
	 * @param list the list
	 * @return the double
	 */
	public static double evenListDouble(List<Double> list) {
		double size = list.size();
		double sum = list.get((int) (size / 2))
				+ list.get((int) (size / 2) - 1);
		return sum / 2;
	}

	/**
	 * Odd list double.
	 *
	 * @param list the list
	 * @return the double
	 */
	public static double oddListDouble(List<Double> list) {
		return list.get(list.size() / 2);
	}

	/**
	 * Median float.
	 *
	 * @param list the list
	 * @return the float
	 */
	public static float medianFloat(List<Float> list) {
		if (list == null || list.size() == 0) {
			return Float.MIN_VALUE;
		}
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListFloat(list);
		}
		return oddListFloat(list);
	}

	/**
	 * Median float.
	 *
	 * @param a the a
	 * @return the float
	 */
	public static float medianFloat(float[] a) {
		if (a == null || a.length == 0) {
			return Float.MIN_VALUE;
		}
		List<Float> list = ArrayUtils.toList(a);
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListFloat(list);
		}
		return oddListFloat(list);
	}

	/**
	 * Even list float.
	 *
	 * @param list the list
	 * @return the float
	 */
	public static float evenListFloat(List<Float> list) {
		float size = list.size();
		float sum = list.get((int) (size / 2)) + list.get((int) (size / 2) - 1);
		return sum / 2;
	}

	/**
	 * Odd list float.
	 *
	 * @param list the list
	 * @return the float
	 */
	public static float oddListFloat(List<Float> list) {
		return list.get(list.size() / 2);
	}

	/**
	 * Median int.
	 *
	 * @param list the list
	 * @return the int
	 */
	public static int medianInt(List<Integer> list) {

		if (list == null || list.size() == 0) {
			return Integer.MIN_VALUE;
		}
		
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListInteger(list);
		}
		return oddListInteger(list);
	}

	/**
	 * Median int.
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int medianInt(int[] a) {

		if (a == null || a.length == 0) {
			return Integer.MIN_VALUE;
		}

		List<Integer> list = ArrayUtils.toList(a);
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			return evenListInteger(list);
		}
		return oddListInteger(list);

	}

	/**
	 * Even list integer.
	 *
	 * @param list the list
	 * @return the int
	 */
	public static int evenListInteger(List<Integer> list) {
		int size = list.size();
		int sum = (int) list.get(size / 2) + (int) list.get((size / 2) - 1);
		return sum / 2;
	}

	/**
	 * Odd list integer.
	 *
	 * @param list the list
	 * @return the int
	 */
	public static int oddListInteger(List<Integer> list) {
		
		return list.get(list.size() / 2);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		//System.out.println(Median.medianFloat());
	}
}
