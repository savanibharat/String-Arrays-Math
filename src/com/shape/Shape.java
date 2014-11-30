package com.shape;

public interface Shape {

	//Insert methods
	Point[] getCoOrdinates();
	double perimeter();
	double area();
	double diagonal();
	boolean contains(Point p);
	String getShape();
	
}
