
public class LineFormal extends AbstractLine implements Line {
	// y = kx+m;
	double k;
	double m;
	
	public LineFormal(double k, double m) {
		this.k = k;
		this.m = m;
	}
	
	public LineFormal(Point p1, Point p2) {
		if (p1.getX() == p2.getX())
			this.k = Double.MAX_VALUE;
		else
			this.k = (p1.getY()-p2.getY())/(p1.getX()-p2.getX());
		this.m = p1.getY() - this.k*p1.getX();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(k);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m);
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
		LineFormal other = (LineFormal) obj;
		if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
			return false;
		if (Double.doubleToLongBits(m) != Double.doubleToLongBits(other.m))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Line: y="+k+"x+"+m;
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		return Math.abs(p.getY() - (this.k*p.getX()+this.m)) < Geometry.Epsilon;
	}

	@Override
	public double distance(Point p) {
		// TODO Auto-generated method stub
		return this.getPerpendicularFoot(p).distance(p);
	}

	@Override
	public Point getPerpendicularFoot(Point p) {
		// TODO Auto-generated method stub
		Line perpendicularLine = this.getPerpendicularLine(p);
		Point foot = this.getIntercept(perpendicularLine);
		return foot;
	}

	@Override
	public boolean onSameLine(Line line) {
		// TODO Auto-generated method stub
		return this.equals(line.getLineFormal());
	}


	@Override
	public Point getIntercept(Line line) {
		// TODO Auto-generated method stub
		if (this.k == line.getSlope()) {
			return null;
		}
		double x= - (this.m-line.getYIntercept()) / (this.k - line.getSlope());
		double y = this.k * x + this.m;
		return new Point(x,y);
	}

	@Override
	public double getAngle(Line line) {
		// TODO Auto-generated method stub
		if (1+line.getSlope()*this.k == 0) {
			return Math.PI/2;
		} 
		return Math.atan(line.getSlope()-this.k)/(1+line.getSlope()*this.k);
	}

	@Override
	public Line getPerpendicularLine(Point p) {
		// TODO Auto-generated method stub
		double slope = -1 / this.k;
		double m = p.getY() - slope*p.getX();
		return new LineFormal(k,m);
	}

	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		return this.k;
	}

	@Override
	public Double getXIntercept() {
		// TODO Auto-generated method stub
		return -m / this.k;
	}

	@Override
	public Double getYIntercept() {
		// TODO Auto-generated method stub
		return this.m;
	}

	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
