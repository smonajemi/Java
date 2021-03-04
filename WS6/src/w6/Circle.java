package w6;

//Circle class implements Shape and extends Main
public class Circle implements ShapePerimeter {
	private double radius;
	
	public Circle(double _radius) {
			super();
			setRadius(_radius);			
	}
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double _radius) throws IllegalArgumentException{
			if(_radius > 0.00)
				this.radius = _radius;
			else
				throw new IllegalArgumentException("Invalid Radius!");
		}
	
	public double getPerimeter() {
		double p =  2 * Math.PI * getRadius();
		return Math.round(p * 10000.0) / 10000.0;		
	}	
	
	ShapeArea area = () -> Math.PI * getRadius() * getRadius();		
	
	public String toString() {
		return "Circle {r=" + Double.toString(getRadius()).toString() + "} -- perimeter = (" + (String.format("%.6g", getPerimeter()) + ") -- area = (" + (String.format("%.2f",area.getArea())) + ")");
	}
	
	}
