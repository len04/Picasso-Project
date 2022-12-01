/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cosine;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the absolute value function
 * 
 * @author Ngoc Le
 *
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Cosine(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
