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
		super("AssignmentException: " + message);
		Frame.setErrorField(message);
		Frame.clickEvaluate();
	}

}
