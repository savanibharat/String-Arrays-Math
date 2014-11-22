package com.arithmetic;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.util.arrays.ArrayUtils;

public class Mode {

	// String array
	public static Map<String, Integer> historgram(String[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

	// histogram for double
	public static Map<Double, Integer> historgram(Double[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		Map<Double, Integer> map = new LinkedHashMap<Double, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}
	
	public static Map<Double, Integer> historgram(double[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		return historgram(ArrayUtils.toObject(arr));
	}

	// histogram for Object[]
	public static Map<Object, Integer> historgram(Object[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		Map<Object, Integer> map = new LinkedHashMap<Object, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

	// histogram for Integer[]
	public static Map<Integer, Integer> historgram(Integer[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<Integer, Integer>();
		}

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

	public static Map<Integer, Integer> historgram(int[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		return historgram(ArrayUtils.toObject(arr));
	}

	// histogram for Float[]
	public static Map<Float, Integer> historgram(Float[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		Map<Float, Integer> map = new LinkedHashMap<Float, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

	public static Map<Float, Integer> historgram(float[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		return historgram(ArrayUtils.toObject(arr));
	}
	
	// histogram for Byte[]
	public static Map<Byte, Integer> historgram(Byte[] arr) {

		if (arr.length == 0 || arr == null) {
			return new HashMap<>();
		}
		Map<Byte, Integer> map = new LinkedHashMap<Byte, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		Object[] a = { 4, 3, 5, 1, 2, 4, 2,"a","a" };
		System.out.println(Mode.historgram(a));

	}
}
