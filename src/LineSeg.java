
public class LineSeg extends AbstractLine implements Line {
	private Point p1, p2;
	
	public LineSeg(Point p1, Point p2) {
		if (p1.compareTo(p2)<=0) {
			this.p1 = p1;
			this.p2 = p2;
		} else {
			this.p1 = p2;
			this.p2 = p1;
		}
	}
	
	public LineSeg(double x1, double y1, double x2, double y2) {
		Point tempP1 = new Point(x1,y1);
		Point tempP2 = new Point(x2,y2);
		
		if (p1.compareTo(p2)<=0) {
			this.p1 = tempP1;
			this.p2 = tempP2;
		} else {
			this.p1 = tempP2;
			this.p2 = tempP1;
		}
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
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
		LineSeg other = (LineSeg) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + p1+","+p2+")";
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		LineFormal line = this.getLineFormal();
		if(line.containsPoint(p) ) {
			if (p1.getX() <= p2.getX()) {
				return p.getX() >= p1.getX() && p.getX() <= p2.getX();
			} 
			else {
				return p.getX() <=p1.getX() && p.getX() >=p2.getX();
			}
		}
		return false;
	}

	@Override
	public double getAngle(Line line) {
		// TODO Auto-generated method stub
		LineFormal line1 = this.getLineFormal();
		LineFormal line2 = line.getLineFormal();
		return line1.getAngle(line2);
	}

	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		if (p1.getX() == p2.getX()) {
			return Double.MAX_VALUE;
		}
		return (p1.getY() - p2.getY()) /(p1.getX()-p2.getX());
	}

	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		return new LineFormal(p1,p2);
	}


	
	
	
}
