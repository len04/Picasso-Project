package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Log;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the log function.
 * 
 * @author Petra Ilic
 * 
 */
public class LogAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Log(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
