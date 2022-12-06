package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exponentiation operation in the Picasso language.
 * 
 * @author Ngoc Le
 * 
 */
public class Exponentiation extends BinaryOperator {

	/**
	 * Create a exponentiation operation that takes as a parameter the given expression
	 * 
	 * @param param the expression to exponentiate
	 */
	public Exponentiation(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the exponentiation of
	 * the operation's parameter.
	 * 
	 * @return the color from evaluating the exponentiation of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		
		double red = Math.pow(result1.getRed(), result2.getRed());
		double green = Math.pow(result1.getGreen(), result2.getGreen());
		double blue = Math.pow(result1.getBlue(), result2.getBlue());

		return new RGBColor(red, green, blue);
	}

}
