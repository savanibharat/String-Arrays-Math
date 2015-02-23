package com.stat;

import java.util.TreeMap;

public class Frequency {

	TreeMap<String, Long> freq;
	private static final long INCREMENT_VALUE = 1;

	public Frequency() {
		freq = new TreeMap<String, Long>();
	}

	public void clear() {
		freq.clear();
	}
	
	public void add(char value) {
		addInTable(String.valueOf(value));
	}

	public void add(double value) {
		addInTable(String.valueOf(value));
	}
	
	public void add(int value) {
		addInTable(String.valueOf(new Double(value)));
	}

	public void add(float value) {
		addInTable(String.valueOf(new Double(value)));
	}

	

	public void addInTable(String value) {

		/**
		 * K is String 
		 * V is count of K
		 * */
		if (freq.containsKey(value)) {
			long previousCount = freq.get(value);
			freq.put(value, previousCount + INCREMENT_VALUE);
		} else {
			freq.put(value, INCREMENT_VALUE);
		}
	}

	public String toString() {
		return freq.toString();
	}

	public static void main(String[] args) {
		Frequency f = new Frequency();
		f.add(1);
		f.add('a');
		f.add('a');
		f.add('a');
		f.add(1.0f);
		f.add(1.0);
		System.out.println(new Float(new Integer(1)));
		System.out.println(f.toString());
	}

}
