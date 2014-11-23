package com.arithmetic;

import java.util.List;

public class SumOfSquares {

	public static double squares(List<Double> list) {

		if (list == null) {
			return Double.NaN;
		} else if (list.size() == 0) {
			return 0d;
		}
		double result = 0d;
		for (int i = 0; i < list.size(); i++) {
			result=result+Math.pow(list.get(i),2);
		}
		return result;
	}

	public static double squares(double d[]) {

		if (d == null) {
			return Double.NaN;
		} else if (d.length == 0) {
			return 0d;
		}
		double result=0d;
		for (int i = 0; i < d.length; i++) {
			result=result+Math.pow(d[i],2);
			System.out.println(result);
		}
		return result;
	}

	public static void main(String[] args) {

		double[] list = new double[4];
		list[0]=1;
		list[1]=5;
		list[2]=4;
		list[3]=3;
		System.out.println(Double.NaN);
		double d=squares(list);
		System.out.println(d);
		
	}
	
}
