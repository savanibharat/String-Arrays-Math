package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Squares {

	public static List<Double> squares(List<Double> list) {

		if (list == null) {
			return null;
		} else if (list.size() == 0) {
			return list;
		}
		List<Double> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Math.pow(list.get(i), 2));
		}
		return result;
	}

	public static double[] squares(double d[]) {

		if (d == null) {
			return null;
		} else if (d.length == 0) {
			return new double[0];
		}
		double[] result=new double[d.length];
		for (int i = 0; i < d.length; i++) {
			result[i]=Math.pow(d[i], 2);
		}
		return result;
	}

	public static void main(String[] args) {

		double[] list = new double[4];
		list[0]=1;
		list[1]=5;
		list[2]=4;
		list[3]=3;
		list=squares(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
	}
}
