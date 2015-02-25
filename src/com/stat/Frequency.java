package com.stat;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Frequency {

	TreeMap<String, Long> freq;
	private static final long INCREMENT_VALUE = 1;
	private static final long ZERO_VALUE = 0;

	public Frequency() {
		freq = new TreeMap<String, Long>();
	}

	public void clear() {
		freq.clear();
	}

	public void add(char value) {
		addInTable(convert(value));
	}

	private String convert(char value) {
		return String.valueOf(value);
	}

	/*
	 * public long getPercent(char value){
	 * 
	 * }
	 */

	public void add(double value) {
		addInTable(convert(value));
	}

	private String convert(double value) {
		return String.valueOf(value);
	}

	public void add(int value) {
		addInTable(convert(value));
	}

	private String convert(int value) {
		return String.valueOf(new Double(value));
	}

	public void add(float value) {
		addInTable(convert(value));
	}

	private String convert(float value) {
		return String.valueOf(new Double(value));
	}

	public void add(String value) {
		addInTable(value);
	}

	public void addInTable(String value) {

		/**
		 * K is String V is count of K
		 * */
		if (freq.containsKey(value)) {
			long previousCount = freq.get(value);
			freq.put(value, previousCount + INCREMENT_VALUE);
		} else {
			freq.put(value, INCREMENT_VALUE);
		}
	}

	public long getCount(char value) {
		return getCount(convert(value));
	}

	public long getCount(int value) {
		return getCount(convert(value));
	}

	public long getCount(float value) {
		return getCount(convert(value));
	}

	public long getCount(double value) {
		return getCount(convert(value));
	}

	public long getCount(String value) {
		if (!isEmpty()) {
			if (freq.containsKey(value)) {
				return freq.get(value).longValue();
			} else {
				return ZERO_VALUE;
			}
		} else {
			return ZERO_VALUE;
		}
	}

	public int getKeysCount() {
		return freq.keySet().size();
	}

	public long getValuesCount() {
		Iterator<Long> iter = freq.values().iterator();
		Long values = 0L;
		while (iter.hasNext()) {
			values = values + iter.next();
		}
		return values.longValue();
	}

	public double getKeyPercent(char value) {
		return getKeyPercent(convert(value));
	}

	public double getKeyPercent(int value) {
		return getKeyPercent(convert(value));
	}

	public double getKeyPercent(float value) {
		return getKeyPercent(convert(value));
	}

	public double getKeyPercent(double value) {
		return getKeyPercent(convert(value));
	}

	public float getKeyPercent(String value) {
		if (!isEmpty()) {
			if (freq.containsKey(value)) {
				return ((float) freq.get(value) / getValuesCount());
			} else {
				return ZERO_VALUE;
			}
		} else {
			return ZERO_VALUE;
		}
	}

	public Iterator<Entry<String, Long>> frequencyIterator() {
		return freq.entrySet().iterator();
	}

	public void insertFrequencies(Frequency frequency) {

		Iterator<Entry<String, Long>> iter = frequency.frequencyIterator();
		while (iter.hasNext()) {
			Entry<String, Long> entry = iter.next();
			System.out.println(entry+".");
			String K = entry.getKey();
			Long V = entry.getValue();
			if (freq.containsKey(K)) {
				freq.put(K, freq.get(K) + V);
			} else {
				freq.put(K, V);
			}
		}
		System.out.println(freq);
	}

	public boolean isEmpty() {
		return freq.isEmpty();
	}

	public String toString() {
		return freq.toString();
	}

	public static void main(String[] args) {
		Frequency f = new Frequency();
		f.add(1);
		f.add('a');
		f.add('a');
		f.add("aaa");
		f.add("aaa");
		f.add("aaa");
		f.add(1.0f);
		f.add(1.0);
		Frequency f1 = new Frequency();
		f1.add(1);
		f1.add('a');
		f1.add("aaa");
		f1.add("aaa");
		f1.add("aaa");
		f1.add(1.0f);
		f1.add(1.0);
		f1.insertFrequencies(f);
	}

}
