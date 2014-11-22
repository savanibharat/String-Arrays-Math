package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class StandardDeviation {

	/**
	 * * Standard Deviation (SD) (represented by the Greek letter sigma)
	 * measures the amount of variation or dispersion from the average.
	 * //Population Standard Deviation /** Standard deviation double.
	 *
	 * @param list
	 *            the list
	 * @param populationStandardDeviation
	 *            the population standard deviation
	 * @return the double
	 */
	public static double standardDeviationDouble(List<Double> list,
			boolean populationStandardDeviation) {

		if (populationStandardDeviation) {
			return Math.sqrt(Variance.varianceDouble(list, populationStandardDeviation));
		}
		return Math.sqrt(Variance.varianceDouble(list, populationStandardDeviation));

	}

	// Population Standard Deviation
	/**
	 * Standard deviation long.
	 *
	 * @param list
	 *            the list
	 * @param populationStandardDeviation
	 *            the population standard deviation
	 * @return the double
	 */
	public static double standardDeviationLong(List<Long> list,
			boolean populationStandardDeviation) {

		if (populationStandardDeviation) {
			return Math.sqrt(Variance.varianceLong(list, populationStandardDeviation));
		}
		return Math.sqrt(Variance.varianceLong(list, populationStandardDeviation));

	}

	// Population Standard Deviation
	/**
	 * Standard deviation integer.
	 *
	 * @param list
	 *            the list
	 * @param populationStandardDeviation
	 *            the population standard deviation
	 * @return the int
	 */
	public static int standardDeviationInteger(List<Integer> list,
			boolean populationStandardDeviation) {

		if (populationStandardDeviation) {
			return (int) Math.sqrt(Variance.varianceInteger(list,
					populationStandardDeviation));
		}
		return (int) Math.sqrt(Variance.varianceInteger(list,
				populationStandardDeviation));
	}
	public static void main(String[] args) {
		
		List<Long> l=new ArrayList<Long>();
		l.add(1l);l.add(-1l);l.add(2l);l.add(-2l);l.add(3l);l.add(-3l);//l.add(88l);l.add(90l);l.add(93l);
		System.out.println(standardDeviationLong(l,true));
		
	}

}
