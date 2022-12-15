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

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the assignment token
		// the parameters are the next tokens on the stack.
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		String var = ((IdentifierToken) tokens.peek()).getName();				
		SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
				
		return new Assignment(var, param);
	}

}
