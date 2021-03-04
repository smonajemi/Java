package w6;
import java.io.IOException;

@SuppressWarnings("serial")
public class TriangleException extends IOException {
	public TriangleException() {
		super();
	}
	public TriangleException(String e) {
		super(e);
	}
}
