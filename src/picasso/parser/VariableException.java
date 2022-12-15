package picasso.parser;
import picasso.view.Frame;

/**
 * Describe an exception that occurred while calling Variable.
 * 
 * @author Fekry Mostafa
 *
 */
@SuppressWarnings("serial")
public class VariableException extends RuntimeException {

	public VariableException(String name) {
		super("VariableException");
		String m = name+ " isn't defined";
		Frame.setErrorField(m);
	}

}
