package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the subtraction operation in the Picasso language.
 * 
 * @author Ngoc Le
 * 
 */
public class Subtraction extends BinaryOperator {

	/**
	 * Create a subtraction expression that takes as two parameters the given expression
	 * 
	 * @param param the expression to subtraction
	 */
	public Subtraction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the subtraction of
	 * the operation's parameters.
	 * 
	 * @return the color from evaluating the subtraction of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		
		double red = result1.getRed() - result2.getRed();
		double green = result1.getGreen() - result2.getGreen();
		double blue = result1.getBlue() - result2.getBlue();

		return new RGBColor(red, green, blue);
	}

}
