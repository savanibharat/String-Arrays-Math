package com.matrix;

public class Matrix implements RealMatrix, MatrixOperations {

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
	 * Transpose of Matrix
	 * */

	public Matrix transpose() {

		boolean isCompatible = Matrix.isMatrixCompatible(this);
		if (isCompatible) {
			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] c = new double[col][row];
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					c[i][j] = this.m[j][i];
				}
			}
			return new Matrix(c);
		}
		return null;
	}

	/**
	 * Identity Matrix are n*n matrix and diagonall filled by 1.
	 * 
	 * [1]
	 * 
	 * [1,0] [0,1]
	 * 
	 * [1,0,0] [0,1,0] [0,0,1]
	 * */
	public static Matrix identityMatrix(int n) {

		Matrix matrix = new Matrix(n, n);

		for (int i = 0; i < n; i++) {
			matrix.m[i][i] = 1;
		}
		matrix.displayMatrix();
		return null;

	}

	/**
	 * Matrix Of Ones matrix of ones or all-ones matrix is a matrix where every
	 * element is equal to one. [1,1]
	 * 
	 * [1,1] [1,1]
	 * 
	 * [1,1,1,1] [1,1,1,1] [1,1,1,1]
	 * */
	public static Matrix matrixOfOnes(int row, int column) {

		Matrix matrix = new Matrix(row, column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix.m[i][j] = 1;
			}
		}
		return matrix;
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
		System.out.println(isCompatibleMatrix);
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
	 * 1 2 3 4 5
	 * */
	public static boolean additionCompatible(Matrix matA, Matrix matB) {
		int colA = matA.getColumnLength();
		int colB = matB.getColumnLength();

		int rowA = matA.getRowLength();
		int rowB = matB.getRowLength();
		if ((colA != colB) || (rowA != rowB)) {
			return false;
		}
		int elemsA = matA.getRowElements(0).length;
		for (int i = 1; i < rowA; i++) {
			int temp = matA.getRowElements(i).length;
			if (elemsA != temp) {
				return false;
			}
		}

		int elemsB = matB.getRowElements(0).length;
		for (int i = 1; i < rowB; i++) {
			int temp = matB.getRowElements(i).length;
			if (elemsB != temp) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Addition {@code this} matrix with matrix in paramter
	 * */
	public Matrix subtract(Matrix matrix) {

		boolean isCompatibleMatrix = Matrix.subtractionCompatible(this, matrix);
		if (isCompatibleMatrix) {
			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] c = new double[row][col];
			for (int i = 0; i < this.getRowLength(); i++) {
				for (int j = 0; j < this.getColumnLength(); j++) {
					c[i][j] = this.m[i][j] - matrix.m[i][j];
				}
			}
			return new Matrix(c);
		}
		return null;
	}

	/**
	 * Use method additionCompatible
	 * */
	public static boolean subtractionCompatible(Matrix matA, Matrix matB) {

		return additionCompatible(matA, matB);
	}

	/**
	 * This method is to be implemented
	 * */
	@Override
	public Matrix divide(Matrix matrix) {

		boolean isCompatibleMatrix = Matrix.divisionCompatible(this, matrix);
		if (isCompatibleMatrix) {
			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] c = new double[row][col];
			for (int i = 0; i < this.getRowLength(); i++) {
				for (int j = 0; j < this.getColumnLength(); j++) {
					c[i][j] = this.m[i][j] / matrix.m[i][j];
				}
			}
			return new Matrix(c);
		}
		return null;
	}

	public static boolean divisionCompatible(Matrix matA, Matrix matB) {
		return additionCompatible(matA, matB);
	}

	public Matrix multiply(Matrix matrix) {

		boolean isCompatibleMatrix = Matrix.multiplicationCompatible(this,
				matrix);
		if (isCompatibleMatrix) {

			int row = this.getRowLength();
			int col = matrix.getColumnLength();
			double[][] multiply = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					for (int k = 0; k < this.getColumnLength(); k++) {
						multiply[i][j] = multiply[i][j]
								+ (this.m[i][k] * matrix.m[k][j]);
					}
				}
			}
			return new Matrix(multiply);
		}
		return null;
	}

	public static boolean multiplicationCompatible(Matrix matA, Matrix matB) {

		boolean isMatrixCompatible1 = isMatrixCompatible(matA);
		boolean isMatrixCompatible2 = isMatrixCompatible(matB);
		int colA = matA.getColumnLength();
		int rowB = matB.getRowLength();
		return ((isMatrixCompatible1 && isMatrixCompatible2) && (colA == rowB));
	}

	public static boolean isMatrixCompatible(Matrix matrix) {

		int rowA = matrix.getRowLength();

		int elemsA = matrix.getRowElements(0).length;
		for (int i = 1; i < rowA; i++) {
			int temp = matrix.getRowElements(i).length;
			if (elemsA != temp) {
				return false;
			}
		}
		return true;
	}

	public Matrix scalarAdd(double scalar) {

		boolean isCompatible = Matrix.isMatrixCompatible(this);
		if (isCompatible) {

			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] scalarAdd = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					scalarAdd[i][j] = scalar + this.m[i][j];
				}
			}
			return new Matrix(scalarAdd);
		}
		return null;
	}

	public Matrix scalarSubtract(double scalar) {

		boolean isCompatible = Matrix.isMatrixCompatible(this);
		if (isCompatible) {

			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] scalarSubtract = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					scalarSubtract[i][j] = scalar - this.m[i][j];
				}
			}
			return new Matrix(scalarSubtract);
		}
		return null;
	}

	public Matrix scalarMultiply(double scalar) {

		boolean isCompatible = Matrix.isMatrixCompatible(this);
		if (isCompatible) {

			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] scalarMultiply = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					scalarMultiply[i][j] = scalar * this.m[i][j];
				}
			}
			return new Matrix(scalarMultiply);
		}
		return null;
	}

	/**
	 * This method is to be implemented
	 * */
	@Override
	public Matrix copy() {
		boolean isCompatible = Matrix.isMatrixCompatible(this);
		if (isCompatible) {

			int row = this.getRowLength();
			int col = this.getColumnLength();
			double[][] matrix = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					matrix[i][j] = this.m[i][j];
				}
			}
			return new Matrix(matrix);
		}
		return null;
	}

	public static void main(String[] args) {

		/**
		 * q+w add each elem with wach elem of other q*2 multiply each elem with
		 * 2
		 * 
		 * */
	}

}