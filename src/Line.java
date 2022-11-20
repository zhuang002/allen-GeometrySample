
public interface Line {
	public boolean containsPoint(Point p);
	public double distance(Point p);
	public Point getPerpendicularFoot(Point p);
	public boolean onSameLine(Line line);
	public boolean isParallel(Line line);
	public boolean isPerpendicular(Line line);
	public Point getIntercept(Line line);
	public double getAngle(Line line); // anti clock;
	public Line getPerpendicularLine(Point p);
	public double getSlope();
	public Double getXIntercept();
	public Double getYIntercept();
	public LineFormal getLineFormal();
}
