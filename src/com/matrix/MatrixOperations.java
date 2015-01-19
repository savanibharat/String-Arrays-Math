package com.matrix;
/**
 * More methods are yet to be added.
 * */
public interface MatrixOperations {

	/**
	 * Copy {@code this} matrix to another matrix and return Matrix
	 * */
	RealMatrix copy();

	/**
	 * 
	 * */
	//RealMatrix trim();

	/**
	 * Addition {@code this} matrix with matrix in paramter
	 * */
	RealMatrix add(RealMatrix matrix);

	/**
	 * Subtract {@code this} matrix with matrix in paramter
	 * */
	RealMatrix subtract(RealMatrix matrix);

	/**
	 * Multiply {@code this} matrix with matrix in paramter
	 * */
	RealMatrix multiply(RealMatrix matrix);

	/**
	 * Divide {@code this} matrix with matrix in paramter
	 * */
	RealMatrix divide(RealMatrix matrix);

}
