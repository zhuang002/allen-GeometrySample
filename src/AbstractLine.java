
public abstract class AbstractLine implements Line {
	@Override
	public double distance(Point p) {
		// TODO Auto-generated method stub
		return this.getLineFormal().distance(p);
	}
	
	@Override
	public Point getPerpendicularFoot(Point p) {
		// TODO Auto-generated method stub
		return this.getIntercept(this.getPerpendicularLine(p));
	}
	


	@Override
	public boolean onSameLine(Line line) {
		// TODO Auto-generated method stub
		return this.getLineFormal().onSameLine(line);
	}

	@Override
	public boolean isParallel(Line line) {
		// TODO Auto-generated method stub
		return Math.abs(this.getSlope()-line.getSlope()) < Geometry.Epsilon;
	}
	
	@Override
	public boolean isPerpendicular(Line line) {
		// TODO Auto-generated method stub
		return Math.abs(this.getSlope()*line.getSlope()+1) < Geometry.Epsilon;
	}
	
	@Override
	public Line getPerpendicularLine(Point p) {
		// TODO Auto-generated method stub
		return this.getLineFormal().getPerpendicularLine(p);
	}
	
	@Override
	public Double getXIntercept() {
		// TODO Auto-generated method stub
		LineFormal line = this.getLineFormal();
		double xIntercept = line.getXIntercept();
		if (this.containsPoint(new Point(xIntercept,0))) {
			return xIntercept;
		}
		return null;
	}
	


	@Override
	public Double getYIntercept() {
		// TODO Auto-generated method stub
		LineFormal line = this.getLineFormal();
		double yIntercept = line.getYIntercept();
		if (this.containsPoint(new Point(0,yIntercept))) {
			return yIntercept;
		}
		return null;
	}
	
	@Override
	public Point getIntercept(Line line) {
		// TODO Auto-generated method stub
		LineFormal line1 = this.getLineFormal();
		LineFormal line2 = this.getLineFormal();
		Point p = line1.getIntercept(line2);
		if (this.containsPoint(p) && line.containsPoint(p))
			return p;
		return null;
	}

}
