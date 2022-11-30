package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Sine;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Sin function.
 * 
 * 
 */
public class SinAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Sine(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
