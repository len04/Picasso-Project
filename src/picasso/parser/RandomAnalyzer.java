package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Random;
import picasso.parser.tokens.Token;

/**
 * Represents the random function in the Picasso language.
 * 
 * @author Petra Illic
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Random();
	}

}
