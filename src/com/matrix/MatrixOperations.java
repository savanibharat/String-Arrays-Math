package com.matrix;

public interface MatrixOperations {

	/**
	 * Copy {@code this} matrix to another matrix and return object of Matrix
	 * */
	Matrix copy();

	/***/
	Matrix trim();

	/***/
	Matrix add(Matrix matrix);

	/***/
	Matrix subtract(Matrix matrix);

	/***/
	Matrix multiply(Matrix matrix);

	/***/
	Matrix divide(Matrix matrix);

}
