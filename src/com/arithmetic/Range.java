package com.arithmetic;

import java.util.Collections;
import java.util.List;

public class Range {

	public static double rangeDouble(List<Double> list) {
		return Math.abs(Collections.max(list)-Collections.min(list));
	}

	public static double rangeDouble(double[] a) {

		double min=Double.MAX_VALUE;
		double max=Double.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(min>a[i]){
				min=a[i];
			}
			if(max<a[i]){
				max=a[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		return Math.abs(max-min);
	}
	
	public static long rangeLong(List<Long> list) {
		return Math.abs(Collections.max(list)-Collections.min(list));
	}

	public static long rangeLong(long[] a) {

		long  min=Long.MAX_VALUE;
		long  max=Long.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(min>a[i]){
				min=a[i];
			}
			if(max<a[i]){
				max=a[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		return Math.abs(max-min);
	}

	public static float rangefloat(List<Float> list) {
		return Math.abs(Collections.max(list)-Collections.min(list));
	}

	public static float rangefloat(float[] a) {
		
		float min=Float.MAX_VALUE;
		float max=Float.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(min>a[i]){
				min=a[i];
			}
			if(max<a[i]){
				max=a[i];
			}
		}
		return (float)Math.abs(max-min);
	}

	public static int rangeInt(List<Integer> list) {
		return Math.abs(Collections.max(list)-Collections.min(list));
	}

	public static int rangeInt(int[] a) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(min>a[i]){
				min=a[i];
			}
			if(max<a[i]){
				max=a[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		return (int)Math.abs(max-min);
	}
}
