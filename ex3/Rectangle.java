package w6;
import java.text.DecimalFormat;

// Rectangle class implements shape and extends Main
public class Rectangle implements ShapePerimeter{
	private double length;
	private double width;
	//constructor
	public Rectangle(double _width, double _length) throws RectangleException {
		super(); // reference to its parents objs
		if(_width > 0.0 && _length > 0.0)
		{
			setLength(_length);
			setWidth(_width);
		}
		else
				throw new RectangleException("Invalid Side!");
	}
	
	public void setLength(double _length) {
			this.length = _length;
	}
	public void setWidth(double _Width) {
		this.width = _Width;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}	
	
	public double getPerimeter() {
		return (getWidth() + getLength()) * 2;
	}
	
	ShapeArea area = () -> getWidth() * getLength();
	
	public String toString() {
		DecimalFormat newFormat = new DecimalFormat("#.0000");
		@SuppressWarnings("deprecation")
		Double temp = new Double(getPerimeter());	
		return "Rectangle {w=" + Double.toString(getWidth()) + ", h=" + Double.toString(getLength()) + "} -- perimeter = (" + (newFormat.format(temp)) + ") -- area = (" + String.format("%.2f", area.getArea()) + ")";
	}

}
