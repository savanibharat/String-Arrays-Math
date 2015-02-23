package com.stat;

import java.util.TreeMap;

public class Frequency {

	TreeMap<String, Long> freq;
	private static final long INCREMENT_VALUE = 1;
	private static final long ZERO_VALUE=0;

	public Frequency() {
		freq = new TreeMap<String, Long>();
	}

	public void clear() {
		freq.clear();
	}
	
	public void add(char value) {
		addInTable(convert(value));
	}
	
	private String convert(char value){
		return String.valueOf(value);
	}
	
	public void add(double value) {
		addInTable(convert(value));
	}
	
	private String convert(double value){
		return String.valueOf(value);
	}
	
	public void add(int value) {
		addInTable(convert(value));
	}
	
	private String convert(int value){
		return String.valueOf(new Double(value));
	}

	public void add(float value) {
		addInTable(convert(value));
	}
	
	private String convert(float value){
		return String.valueOf(new Double(value));
	}

	public void add(String value){
		addInTable(value);
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
	
	public Long getCount(char value){
		return getCount(convert(value));/*
		if(freq.size()>0){
			return freq.get(convert(value));
		}
		else{
			return ZERO_VALUE;
		}*/
	}
	
	public Long getCount(int value){
		return getCount(convert(value));
	}

	public Long getCount(float value){
		return getCount(convert(value));
	}
	
	public Long getCount(double value){
		return getCount(convert(value));
	}
	
	public Long getCount(String value){
		if(!isEmpty()){
			if(freq.containsKey(value)){
				return freq.get(value);
			}
			else{
				return ZERO_VALUE;
			}
		}else{
			return ZERO_VALUE;
		}
	}
	
	public boolean isEmpty(){
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
		f.add(1.0f);
		f.add(1.0);
		System.out.println(f.getCount('z'));
		System.out.println(f.toString());
	}

}
