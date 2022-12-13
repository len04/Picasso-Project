package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Inversion;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the inversion operation.
 * 
 * @author Ngoc le
 * 
 */
public class InvertAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the inversion token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Inversion(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
