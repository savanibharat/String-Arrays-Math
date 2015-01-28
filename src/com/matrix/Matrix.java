package com.matrix;

public class Matrix implements RealMatrix {

	private double[][] m;

	public Matrix(double[][] m) {
		this.m = m;
	}

	public Matrix() {
	}

	/**
	 * Will throw NullPointerException is m is null. Use
	 * */
	public Matrix(final int rowDimension, final int colDimension) {
		this.m = new double[rowDimension][colDimension];
		System.out.println(m.length);
		System.out.println(m[0].length);
	}

	/**
	 * TAKEN FROM WIKI http://en.wikipedia.org/wiki/Matrix_(mathematics) A
	 * matrix with the same number of rows and columns, sometimes used to
	 * represent a linear transformation from a vector space to itself, such as
	 * reflection, rotation, or shearing.
	 * */
	@Override
	public boolean isSquareMatrix() {
		if (getRowLength() == getColumnLength()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the Length of the Matrix.
	 * */
	@Override
	public int getRowLength() {
		return this.m.length;
	}

	/**
	 * Returns the column of the Matrix Will work as index and not positions
	 * */
	@Override
	public int getColumnLength() {
		return this.m[0].length;
	}

	/**
	 * Returns the row elements. Will work as index and not positions
	 * */
	@Override
	public double[] getRowElements(final int rowNumber) {
		int row = getRowLength();
		if (rowNumber > row) {
			return null;
		}
		return this.m[rowNumber];
	}

	/**
	 * Returns the row elements. Will work as index and not positions
	 * */
	@Override
	public double[] getColumnElements(final int columnNumber) {
		int row = getRowLength();
		int col = getColumnLength();
		if (columnNumber > col) {
			return null;
		}
		double d[] = new double[row];
		for (int i = 0; i < row; i++) {
			d[i] = this.m[i][columnNumber];
		}
		return d;
	}

	/**
	 * TAKEN FROM WIKI http://en.wikipedia.org/wiki/Matrix_(mathematics) A
	 * matrix with one row, sometimes used to represent a vector.
	 * */
	@Override
	public boolean isRowVector() {
		if ((getRowLength() == 1) && (getColumnLength() > 0)) {
			return true;
		}
		return false;
	}

	/**
	 * TAKEN FROM WIKI http://en.wikipedia.org/wiki/Matrix_(mathematics) A
	 * matrix with one column, sometimes used to represent a vector.
	 * */
	@Override
	public boolean isColumnVector() {
		if ((getRowLength() > 0) && (getColumnLength() == 1)) {
			return true;
		}
		return false;
	}

	/**
	 * TAKEN FROM WIKI http://en.wikipedia.org/wiki/Matrix_(mathematics) An
	 * empty matrix is a matrix in which the number of rows or columns (or both)
	 * is zero. Empty matrices help dealing with maps involving the zero vector
	 * space. For example, if A is a 3-by-0 matrix and B is a 0-by-3 matrix,
	 * then AB is the 3-by-3 zero matrix corresponding to the null map from a
	 * 3-dimensional space V to itself, while BA is a 0-by-0 matrix. There is no
	 * common notation for empty matrices, but most computer algebra systems
	 * allow creating and computing with them. The determinant of the 0-by-0
	 * matrix is 1 as follows from regarding the empty product occurring in the
	 * Leibniz formula for the determinant as 1. This value is also consistent
	 * with the fact that the identity map from any finite dimensional space to
	 * itself has determinant 1, a fact that is often used as a part of the
	 * characterization of determinants.
	 * */

	@Override
	public boolean isEmptyMatrix() {
		if ((getRowLength() == 0) && (getColumnLength() == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to display the matrix in tabular form The
	 * getRowLength(matrix) is used to get the total number of rows in matrix.
	 * so we run a loop
	 * 
	 * for each row in matrix for all elements in row print elements
	 * */
	public void displayMatrix() {
		int rows = getRowLength();
		for (int i = 0; i < rows; i++) {
			double d[] = getRowElements(i);
			for (int j = 0; j < d.length; j++) {
				System.out.print(d[j] + "	");
			}
			System.out.println();
		}
	}

	/**
	 * Addition {@code this} matrix with matrix in paramter
	 * */
	public Matrix add(Matrix matrix) {

		boolean isCompatibleMatrix = Matrix.additionCompatible(this, matrix);

		if (isCompatibleMatrix) {
			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] c = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					c[i][j] = this.m[i][j] + matrix.m[i][j];
				}
			}
			return new Matrix(c);
		}
		return null;
	}

	/**
	 * Yet to implement this method.
	 * */
	public static boolean additionCompatible(Matrix matA, Matrix matB) {
		return true;
	}

	/**
	 * Addition {@code this} matrix with matrix in paramter
	 * */
	public Matrix subtract(Matrix matrix) {

		Matrix.subtractionCompatible(this, matrix);
		this.displayMatrix();
		matrix.displayMatrix();
		// if (isCompatibleMatrix) {
		int row = this.getRowLength();
		int col = this.getColumnLength();
		double[][] c = new double[row][col];
		for (int i = 0; i < this.getRowLength(); i++) {
			for (int j = 0; j < this.getColumnLength(); j++) {
				c[i][j] = this.m[i][j] - matrix.m[i][j];
			}
		}
		return new Matrix(c);
		// }
		// return new Matrix();
	}

	/**
	 * Yet to implement this method.
	 * */
	public static void subtractionCompatible(Matrix matA, Matrix matB) {

		if ((matA.getRowLength() != matB.getRowLength())
				|| (matA.getColumnLength() != matB.getColumnLength())) {
			/*
			 * System.out.println("False"); return false;
			 */
			throw new IllegalArgumentException();
		}
		System.out.println("True");
		// return true;
	}

	public static void main(String[] args) {

		// double[][] m1 = { { 1d, 2d, 3d }, { 2d, 5d, 3d } };
		double[][] m1 = { { 1, 2 }, { 3, 4, 5 } };
		double[][] m2 = { { 9, 10 }, { 12, 13, 14 } };
		Matrix mat1 = new Matrix(m1);
		Matrix mat2 = new Matrix(m2);
		// mat1.displayMatrix();
		System.out.println();
		// mat2.displayMatrix();
		Matrix mat3 = mat1.subtract(mat2);
		System.out.println();
		mat3.displayMatrix();
	}
}