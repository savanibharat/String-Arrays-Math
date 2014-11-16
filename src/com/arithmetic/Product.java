package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Product {

	public static double product(List<Double> list) {

		if (list == null) {
			return 0;
		} else if (list.size() == 0) {
			return 0;
		}
		double product = 1d;
		for (int i = 0; i < list.size(); i++) {
			product = product * list.get(i);
		}
		return product;
	}

	public static void main(String[] args) {

		List<Double> list = new ArrayList<Double>();
		list.add(1d);
		list.add(2d);
		list.add(4d);
		list.add(16d);
		System.out.println(product(list));
	}

}
