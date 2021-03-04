package w6;

//Square class implements Rectangle and extends Main
public class Square extends Rectangle {
	public Square(double _width) throws RectangleException {
		super(_width,_width); // inheriting objects from the parent class - constructor
	}
	
	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}
	
	ShapeArea area = () -> getWidth() * getWidth();
	
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		Double temp = new Double(getPerimeter());	
		return "Square {s=" + Double.toString(getWidth()).toString() + "} -- perimeter = (" + (String.format("%.6g", temp)) + ") -- area = (" + String.format("%.2f",area.getArea()) + ")";
	}

}