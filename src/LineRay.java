
public class LineRay extends AbstractLine, implements Line {
	private Point start;
	private double angle;  // 0 <= angle < 2pi
	
	public LineRay(Point start, double angle) {
		this.start = start;
		while (angle>2*Math.PI) {
			angle-=2*Math.PI;
		}
		this.angle = angle;
	}
	
	public LineRay(Point start, Point direction) {
		this.start = start;
		double slope;
		if (direction.getX() == this.start.getX())
			slope = Double.MAX_VALUE;
		else
			slope= (direction.getY() - this.start.getY()) / (direction.getX() - this.start.getX());
		
		if (slope == Double.MAX_VALUE) {
			if (this.start.getY() > direction.getY()) {
				angle = 3*Math.PI/2;
			} else {
				angle = Math.PI/2;
			}
			return;
		}
		
		this.angle = Math.atan(slope);
		
		if (this.angle > 0) {
			if (direction.getX() < this.start.getX())
				this.angle+=Math.PI;
		} else if (this.angle<0) {
			if (direction.getX() < this.start.getX()) {
				this.angle+=Math.PI;
			}
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		LineRay other = (LineRay) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + start + "," + angle + ")";
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		if (this.start.equals(p))
			return true;
		
		Line line=this.getLineFormal();
		if (! line.containsPoint(p))
			return false;
		
		if (p.getX()>=this.start.getX()) {
			if (p.getY()>=this.start.getY()) {
				return angle <= Math.PI/2;
			} else {
				return 3*Math.PI/2 <= angle; 
			}
		}  else {
			if (p.getY()>=this.start.getY()) {
				return angle >= Math.PI/2 && angle <= Math.PI;
			} else {
				return angle >= Math.PI && angle <= 3*Math.PI/2;
			}
		}
	}

	

	

	

	@Override
	public double getAngle(Line line) {
		// TODO Auto-generated method stub
		LineFormal line1 = this.getLineFormal();
		LineFormal line2 = this.getLineFormal();
		double angle = line1.getAngle(line2);
		pass
		return 0;
	}

	

	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		return Math.tan(angle);
	}

	

	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		double k;
		if (angle==Math.PI/2 || angle == Math.PI*3/2) {
			k=Double.MAX_VALUE;
		} else {
			k = Math.tan(angle);
		}
		double m = this.start.getY() - k*this.start.getX();
		return new LineFormal(k,m);
	}
	
	
}

