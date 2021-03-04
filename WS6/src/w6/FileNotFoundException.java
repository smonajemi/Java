package w6;
import java.io.IOException;

@SuppressWarnings("serial")
public class FileNotFoundException extends IOException {
	public FileNotFoundException() {
		super();
	}
	public FileNotFoundException(String e) {
		super(e);
	}
}
