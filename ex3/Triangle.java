package w6;
import java.text.DecimalFormat;

//Triangle class implements Shape and extends Main
public class Triangle implements ShapePerimeter {
	private double a,b,c;
	
	public Triangle(double a,double b, double c) throws TriangleException{
		if((a > 0 && b > 0 && c > 0) && (a + b) > c && (a + c) > b && (b + c) > a)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		} else
			throw new TriangleException("Invalid Side(s)!");
	}
	
	public double getSide_a() {
		return a;
	}
	public double getSide_b() {
		return b;
	}
	public double getSide_c() {
		return c;
	}
	
	public double getPerimeter() {
		return a + b + c;
	}
	
	public String toString() {
		DecimalFormat newFormat = new DecimalFormat("#.0000");
		@SuppressWarnings("deprecation")
		Double temp = new Double(getPerimeter());	
		return "Triangle {s1=" + Double.toString(getSide_a()) + ", s2=" + Double.toString(getSide_b()) + ", s3=" + Double.toString(getSide_c()) + "} perimeter = " + (newFormat.format(temp));
	}

}
