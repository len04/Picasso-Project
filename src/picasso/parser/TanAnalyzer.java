package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tangent;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Tan function.
 * 
 * 
 * @author Matt Stock
 * 
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Tangent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
