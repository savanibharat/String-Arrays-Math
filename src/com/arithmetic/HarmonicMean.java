package com.arithmetic;

import java.util.List;

public class HarmonicMean {

	public static double harmonicMean(List<Double> list) {

		if (list == null) {
			return 0;
		} else if (list.size() == 0) {
			return 0;
		}
		double product = 1d;
		double sum = 0d;
		for (int i = 0; i < list.size(); i++) {
			product = product * list.get(i);
			sum = sum + list.get(i);
		}
		product = product * list.size();
		return product / sum;
	}

	public static double harmonicMean(double[] list) {

		if (list == null) {
			return Double.NaN;
		} else if (list.length == 0) {
			return Double.NaN;
		}
		double product = 1d;
		double sum = 0d;
		for (int i = 0; i < list.length; i++) {
			product = product * list[i];
			sum = sum + list[i];
		}
		product = product * list.length;
		return product / sum;
	}

	public static void main(String[] args) {

		double[] list=new double[2];
		list[0]=40d;
		list[1]=80d;
		System.out.println(harmonicMean(list));

	}
}
