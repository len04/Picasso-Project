package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the rgbToYCrCb function.
 * 
 * @author Ngoc le
 * 
 */

public class RgbToYCrCbAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new RgbToYCrCb(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
