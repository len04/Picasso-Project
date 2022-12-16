package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.Token;
/**
 * Handles Parsing the ImageClip function.
 * 
 * @author Petra Ilic
 */
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		ExpressionTreeNode param3 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode image = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new ImageClip((Image) image, param2, param3);	
	}

}