package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the invert sign token
 * 
 * @author Ngoc Le
 * 
 */
public class InvertToken extends CharToken implements OperationInterface {
	public InvertToken() {
		super(CharConstants.BANG);
	}
}
