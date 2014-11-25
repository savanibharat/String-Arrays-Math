package com.shape;

// TODO: Auto-generated Javadoc
/**
 * The Class Square.
 */
public class Square {

	/** The side a. */
	private double sideA;

	/** The side b. */
	private double sideB;

	/** The side c. */
	private double sideC;

	/** The side d. */
	private double sideD;

	/**
	 * Instantiates a new square.
	 */
	public Square() {
		sideA = sideB = sideC = sideD = 0;
	}

	/**
	 * Instantiates a new square.
	 *
	 * @param sideA
	 *            the side a
	 * @param sideB
	 *            the side b
	 * @param sideC
	 *            the side c
	 * @param sideD
	 *            the side d
	 */
	public Square(double sideA, double sideB, double sideC, double sideD) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/**
	 * Instantiates a new square.
	 *
	 * @param p1
	 *            the p1
	 * @param p2
	 *            the p2
	 * @param p3
	 *            the p3
	 * @param p4
	 *            the p4
	 */
	public Square(Point p1, Point p2, Point p3, Point p4) {

	}

	/**
	 * @return the sideA
	 */
	public double getSideA() {
		return sideA;
	}

	/**
	 * @param sideA
	 *            the sideA to set
	 */
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	/**
	 * @return the sideB
	 */
	public double getSideB() {
		return sideB;
	}

	/**
	 * @param sideB
	 *            the sideB to set
	 */
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	/**
	 * @return the sideC
	 */
	public double getSideC() {
		return sideC;
	}

	/**
	 * @param sideC
	 *            the sideC to set
	 */
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	/**
	 * @return the sideD
	 */
	public double getSideD() {
		return sideD;
	}

	/**
	 * @param sideD
	 *            the sideD to set
	 */
	public void setSideD(double sideD) {
		this.sideD = sideD;
	}

	/**
	 * Perimeter.
	 *
	 * @return the double
	 */
	public double perimeter() {
		return 4 * sideA;
	}

	/**
	 * Area.
	 *
	 * @return the double
	 */
	public double area() {
		return sideA * sideA;
	}

	/**
	 * Diagonal.
	 *
	 * @return the double
	 */
	public double diagonal() {
		return (double) (Math.sqrt(2)) * sideA;
	}

	public boolean isSquare() {
		if (!((sideA == sideB) && (sideB == sideC) && (sideC == sideD))) {
			return false;
		}
		return true;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Square s = new Square(5, 5, 5, 5);
		System.out.println(s.isSquare());
		System.out.println(s.perimeter());
		System.out.println(s.diagonal());
		System.out.println(s.area());
	}
}
