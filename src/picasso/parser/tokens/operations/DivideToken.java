package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the divide sign token
 * 
 * @author Ngoc Le
 * 
 */
public class DivideToken extends CharToken implements OperationInterface {
	public DivideToken() {
		super(CharConstants.MOD);
	}
}
