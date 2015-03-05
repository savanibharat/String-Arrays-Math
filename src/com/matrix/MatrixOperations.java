package com.matrix;
/**
 * More methods are yet to be added.
 * */
public interface MatrixOperations extends ScalarOperations{

	/**
	 * Copy {@code this} matrix to another matrix and return Matrix
	 * */
	Matrix copy();

	/**
	 * 
	 * */
	//RealMatrix trim();

	/**
	 * Addition {@code this} matrix with matrix in paramter
	 * */
	Matrix add(Matrix matrix);

	/**
	 * Subtract {@code this} matrix with matrix in paramter
	 * */
	Matrix subtract(Matrix matrix);

	/**
	 * Multiply {@code this} matrix with matrix in paramter
	 * */
	Matrix multiply(Matrix matrix);

	/**
	 * Divide {@code this} matrix with matrix in paramter
	 * */
	Matrix divide(Matrix matrix);

}
