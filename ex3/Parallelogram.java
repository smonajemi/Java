package w6;
import java.text.DecimalFormat;

//Parallelogram class implements Rectangle and extends Main
public class Parallelogram extends Rectangle{

	public Parallelogram(double _width, double _length) throws RectangleException {
		super(_width, _length);		
	}
	
	@Override
	public double getPerimeter() {
		return (getWidth() + getLength()) * 2;
	}
	
	@Override
	public String toString() {
		DecimalFormat newFormat = new DecimalFormat("#.0000");
		@SuppressWarnings("deprecation")
		Double temp = new Double(getPerimeter());	
		return "Parallelogram {w=" + Double.toString(getWidth()) + ", h=" + Double.toString(getLength()) + "} perimeter = " + (newFormat.format(temp));
	}

}
