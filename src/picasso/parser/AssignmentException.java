package picasso.parser;
import picasso.view.Frame;

/**
 * Describe an exception that occurred during assignment.
 * 
 * @author Fekry Mostafa
 *
 */
@SuppressWarnings("serial")
public class AssignmentException extends RuntimeException {

	public AssignmentException(String message) {
		super("ParseException: " + message);
		System.out.println("REACHED");
		Frame.setErrorField(message);
	}

}
