
public class Point implements Comparable{
	private double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	
	public double distance(Point p) {
		double deltaX = this.x - p.x;
		double deltaY = this.y - p.y;
		return Math.sqrt(deltaX*deltaX+deltaY*deltaY);
	}
	
	public static double distance(Point p1, Point p2) {
		return p1.distance(p2);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Point other = (Point)o;
		if (this.x < other.x && Math.abs(this.x-other.x) > Geometry.Epsilon)
			return -1;
		else if (this.x > other.x && Math.abs(this.x-other.x) > Geometry.Epsilon)
			return 1;
		else {
			if (this.y < other.y && Math.abs(this.y-other.y) > Geometry.Epsilon) {
				return -1;
			} else if (this.y > other.y && Math.abs(this.y-other.y) > Geometry.Epsilon) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	
	
}
