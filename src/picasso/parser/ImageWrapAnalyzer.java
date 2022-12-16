package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.Token;
/**
 * Handles parsing the ImageWrap function
 * 
 * @author Petra Ilic
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		ExpressionTreeNode param3 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode image = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new ImageWrap((Image) image, param2, param3);	
	}

}
