package com.arithmetic;

import java.util.List;

public class Variance {

	/**
	 * Variance double.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the double
	 */
	public static double varianceDouble(List<Double> list,boolean populationStandardDeviation){
		
		double mean=Mean.meanDouble(list);
		double variance=0;
		for (int i = 0; i < list.size(); i++) {
			double a=Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/(list.size()-1);	
		}
		return variance/(list.size());
	}
	
	/**
	 * Variance long.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the long
	 */
	public static long varianceLong(List<Long> list,boolean populationStandardDeviation){
		
		long mean=Mean.meanLong(list);
		long variance=0;
		for (int i = 0; i < list.size(); i++) {
			long a=(long) Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/(list.size()-1);	
		}
		return variance/(list.size());
	}
	
	/**
	 * Variance integer.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the int
	 */
	public static int varianceInteger(List<Integer> list,boolean populationStandardDeviation){
		
		int mean=Mean.meanInteger(list);
		int variance=0;
		for (int i = 0; i < list.size(); i++) {
			int a=(int) Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/list.size();	
		}
		return variance/(list.size()-1);
	}
	
}
