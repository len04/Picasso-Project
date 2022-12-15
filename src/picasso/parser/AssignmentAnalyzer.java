package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Assignment;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Assignment operation.
 * 
 * @author Fekry Mostafa
 * 
 */
public class AssignmentAnalyzer implements SemanticAnalyzerInterface {

	private String var;

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the assignment token
		// the parameters are the next tokens on the stack.
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		Token t = tokens.peek();
		String tString = t.toString();
		if (!(t instanceof IdentifierToken) 
			|| (tString.contains("x"))
			|| (tString.contains("y"))) {
				throw new AssignmentException((tString + " can't be assigned"));}
		var = ((IdentifierToken) tokens.peek()).getName();				
		SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Assignment(var, param);		
	}
}
