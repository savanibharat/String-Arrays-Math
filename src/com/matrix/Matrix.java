package com.matrix;

// TODO: Auto-generated Javadoc
/**
 * The Interface Matrix.
 */
public interface Matrix {

	/** Determines whether Matrix is Square matrix or not */
	/**
	 * Checks if is square matrix.
	 *
	 * @param matrix
	 *            the matrix
	 * @return true, if is square matrix
	 */
	boolean isSquareMatrix(Matrix matrix);

	/** Returns the Row Length of the Matrix */
	/**
	 * Gets the row length.
	 *
	 * @param matrix
	 *            the matrix
	 * @return the row length
	 */
	int getRowLength(Matrix matrix);

	/** Returns the Column Length of the Matrix */
	/**
	 * Gets the column length.
	 *
	 * @param matrix
	 *            the matrix
	 * @return the column length
	 */
	int getColumnLength(Matrix matrix);

	/** Returns the array for specified Row else returns null */
	/**
	 * Gets the row elements.
	 *
	 * @param rowNumber
	 *            the row number
	 * @return the row elements
	 */
	double[] getRowElements(int rowNumber);

	/** Returns the array for specified Column else returns null */
	/**
	 * Gets the column elements.
	 *
	 * @param columnNumber
	 *            the column number
	 * @return the column elements
	 */
	double[] getColumnElements(int columnNumber);

	/** Checks whether the Matrix is Row Vector or not */
	/**
	 * Checks if is row vector.
	 *
	 * @param matrix
	 *            the matrix
	 * @return true, if is row vector
	 */
	boolean isRowVector(Matrix matrix);

	/** Checks whether the Matrix is Column Vector or not */
	/**
	 * Checks if is column vector.
	 *
	 * @param matrix
	 *            the matrix
	 * @return true, if is column vector
	 */
	boolean isColumnVector(Matrix matrix);
	
	/** Checks whether the Matrix is Empty or not
	 * Rows -> 0
	 * Columns -> 0
	 * */
	/**
	 * Checks if is empty matrix.
	 *
	 * @param matrix the matrix
	 * @return true, if is empty matrix
	 */
	boolean isEmptyMatrix(Matrix matrix);

}