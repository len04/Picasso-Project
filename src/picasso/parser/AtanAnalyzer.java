package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ArcTangent;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the atan function.
 * 
 * @author Petra Ilic
 * 
 */
public class AtanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new ArcTangent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
