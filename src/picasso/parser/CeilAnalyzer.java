package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.tokens.Token;
/**
 * Handles parsing the ceil function
 * 
 * @author Petra Ilic
 *
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Ceiling(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
