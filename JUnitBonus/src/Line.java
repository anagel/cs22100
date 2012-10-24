
public abstract class Line {

	private double slope;
	private double intercept;
	
	public abstract double getSlope();
	public abstract void setSlope(double slope);
	public abstract double getIntercept();
	public abstract void setIntercept(double slope);
	public abstract void derive(double x1, double y1, double x2, double y2);
}
