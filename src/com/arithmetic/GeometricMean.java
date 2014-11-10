package com.arithmetic;

import java.util.List;

public class GeometricMean {

	public static double geoMetricMean(List<Double> list) {

		if (list == null) {
			return Double.NaN;
		} else if (list.size() == 0) {
			return Double.NaN;
		}
		double product = 1d;
		for (int i = 0; i < list.size(); i++) {
			product = product * list.get(i);
		}
		
		return Math.pow(product,(1.0/list.size()));
	}

	public static double geoMetricMean(double[] list) {

		if (list == null) {
			return Double.NaN;
		} else if (list.length == 0) {
			return Double.NaN;
		}
		double product = 1d;
		for (int i = 0; i < list.length; i++) {
			product = product * list[i];
		}
		return Math.pow(product,(1.0/list.length));
	}

	public static void main(String[] args) {

		double[] list=new double[2];
		list[0]=1d;
		//list[1]=2d;
		list[1]=80d;
		System.out.println(geoMetricMean(list));

	}

	
}
