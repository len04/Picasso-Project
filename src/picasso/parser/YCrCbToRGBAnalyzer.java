package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.YCrCbToRGB;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the rgbToYCrCb function.
 * 
 * @author Ngoc le
 * 
 */

public class YCrCbToRGBAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new YCrCbToRGB(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
