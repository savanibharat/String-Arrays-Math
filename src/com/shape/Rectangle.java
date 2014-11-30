package com.shape;

public class Rectangle implements Shape{

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
	public Rectangle() {
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
	public Rectangle(double sideA, double sideB, double sideC, double sideD) {
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
	public Rectangle(Point p1, Point p2, Point p3, Point p4) {

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
		return sideA + sideB + sideC + sideD;
	}

	/**
	 * Area.
	 *
	 * @return the double
	 */
	public double area() {

		if ((sideA == sideB) && (sideC == sideD)) {
			return (sideA * sideC);
		}
		if ((sideA == sideD) && (sideB == sideC)) {
			return (sideA * sideC);
		}
		if ((sideA == sideC) && (sideB == sideD)) {
			return (sideA * sideB);
		}
		return -1;
	}

	/**
	 * Diagonal.
	 *break this method for better usage
	 * @return the double
	 */
	public double diagonal() {
		if ((sideA == sideB) && (sideC == sideD)) {
			System.out.println(Math.pow(sideA, 2)+Math.pow(sideC, 2));
			return Math.sqrt((Math.pow(sideA, 2)+Math.pow(sideC, 2)));
		}
		if ((sideA == sideD) && (sideB == sideC)) {
			return Math.sqrt((Math.pow(sideA, 2)+Math.pow(sideC, 2)));
		}
		if ((sideA == sideC) && (sideB == sideD)) {
			return Math.sqrt((Math.pow(sideA, 2)+Math.pow(sideB, 2)));
		}
		return -1;
	}
//to be built
	public boolean isRectangle() {
		
		if ((sideA == sideB) && (sideC == sideD)) {
			return true;
		}
		if ((sideA == sideD) && (sideB == sideC)) {
			return true;
		}
		if ((sideA == sideC) && (sideB == sideD)) {
			return true;
		}
		return false;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Rectangle s = new Rectangle(2, 4, 4, 2);
		System.out.println(s.perimeter());
		System.out.println("rect "+s.isRectangle());
		System.out.println(s.diagonal());
		System.out.println("area " + s.area());
	}

	@Override
	public Point[] getCoOrdinates() {
		return null;
	}

	@Override
	public boolean contains(Point p) {
		
		return false;
	}

	@Override
	public String getShape() {
		return "Rectangle";
	}
}
