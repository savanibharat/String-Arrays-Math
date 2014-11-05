package com.shape;

// TODO: Auto-generated Javadoc
/**
 * The Class Triangle.
 */
public class Triangle {

	/** The side a. */
	private double sideA;

	/** The side b. */
	private double sideB;

	/** The side c. */
	private double sideC;

	/**
	 * Instantiates a new triangle.
	 *
	 * @param sizeA
	 *            the size a
	 * @param sizeB
	 *            the size b
	 * @param sizeC
	 *            the size c
	 */
	public Triangle(double sizeA, double sizeB, double sizeC) {
		this.sideA = sizeA;
		this.sideB = sizeB;
		this.sideC = sizeC;

		if (sideA < 0 || sideB < 0 || sideC < 0 || ((sideA + sideB) < sideC)
				|| ((sideB + sideC) < sideA) || ((sideA + sideC) < sideB)) {
			System.out.println("Error");
		}

	}

	/**
	 * Instantiates a new triangle.
	 */
	public Triangle() {
		sideA = 0;
		sideB = 0;
		sideC = 0;
	}

	/**
	 * * Area of Triangle
	 * http://onlinemschool.com/math/assistance/figures_area/triangle/ s =0.5(a
	 * + b + c). Math.sqrt(s(s-a)(s-b)(s-c))
	 *
	 * @return the double
	 */
	public double area() {
		double s = (0.5) * (sideA + sideB + sideC);
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}

	/**
	 * Checks if is equilateral.
	 *
	 * @return true, if is equilateral
	 */
	public boolean isEquilateral() {
		return ((sideA == sideB) && (sideB == sideC));
	}

	/**
	 * Checks if is scalene.
	 *
	 * @return true, if is scalene
	 */
	public boolean isScalene() {
		if ((sideA != sideB) && (sideA != sideC) && (sideB != sideC)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is isoceles.
	 *
	 * @return true, if is isoceles
	 */
	public boolean isIsoceles() {
		if ((sideA != sideB) && (sideB == sideC)) {
			return true;
		}
		return false;
	}

	/**
	 * Perimeter.
	 *
	 * @return the double
	 */
	public double perimeter() {
		return sideA + sideB + sideC;
	}

	/**
	 * * (x1, y1) , (x2, y2) and (x3, y3)be the coordinates of the vertices of
	 * the triangle. (x1+x2+x3)/3) + ((y1,y2,y3)/3)
	 * 
	 * x1 = -1, y1 = -3 x2 = 2, y2 = 1 x3 = 8, y3 = -4
	 *
	 * @param p1
	 *            the p1
	 * @param p2
	 *            the p2
	 * @param p3
	 *            the p3
	 * @return the point
	 */
	public Point centroid(Point p1, Point p2, Point p3) {

		double x1 = p1.getX();
		double x2 = p2.getX();
		double x3 = p3.getX();

		double y1 = p1.getY();
		double y2 = p2.getY();
		double y3 = p3.getY();

		return new Point((x1 + x2 + x3) / 3, (y1 + y2 + y3) / 3);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		Triangle t = new Triangle(2, 3, 3);
		double d = t.area();
		System.out.println(d);
		System.out.println("equi " + t.isEquilateral());
		System.out.println("scalene " + t.isScalene());
		System.out.println("iso " + t.isIsoceles());
		System.out.println(t.centroid(new Point(-1, -3), new Point(2, 1),
				new Point(8, -4)));
	}
}
