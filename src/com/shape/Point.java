package com.shape;

//TODO: Auto-generated Javadoc
/**
* The Class Point.
*/
public class Point {

	/** The x. */
	private double x;

	/** The y. */
	private double y;

	/**
	 * Instantiates a new point.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Point(double x, double y) {

		this.x = x;
		this.y = y;

	}

	/**
	 * Instantiates a new point.
	 */
	public Point() {
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Distance.
	 *
	 * @param p1
	 *            the p1
	 * @param p2
	 *            the p2
	 * @return the float
	 */
	public static double distance(Point p1, Point p2) {

		double x2 = p2.getX();
		double x1 = p1.getX();
		double y2 = p2.getY();
		double y1 = p1.getY();

		double y = (float) Math.sqrt(Math.pow((x2 - x1), 2)
				+ Math.pow((y2 - y1), 2));
		System.out.println(y);
		return y;
	}

	/**
	 * Mid point.
	 *
	 * @param p1
	 *            the p1
	 * @param p2
	 *            the p2
	 * @return the point
	 */
	public static Point midPoint(Point p1, Point p2) {

		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();

		return new Point(((x1 + x2) / 2), ((y1 + y2) / 2));

	}

	public static double slope(Point p1, Point p2) {

		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();

		double slope = ((y2 - y1) / (x2 - x1));
		return slope;
	}

	public static boolean isParallel(Point p1, Point p2, Point p3, Point p4) {

		return (Point.slope(p1, p2)) == (Point.slope(p3, p4));

	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

}
