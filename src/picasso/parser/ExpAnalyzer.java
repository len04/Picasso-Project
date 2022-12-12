package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponential;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the exp function.
 * 
 * @author Petra Ilic
 * 
 */
public class ExpAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Exponential(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
