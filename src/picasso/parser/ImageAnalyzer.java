package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.tokens.ImageToken;
import picasso.parser.tokens.Token;


/**
 * Handles parsing the image expression.
 * 
 * @author Petra Ilic
 *
 */
public class ImageAnalyzer implements SemanticAnalyzerInterface{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// get image token when pop it
		ImageToken it = (ImageToken) tokens.pop();
		// get name of image from image token
		String imageName = it.getName();
		return new Image(imageName);
	}

}
