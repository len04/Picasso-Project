package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the negation operation in the Picasso language.
 * 
 * @author Ngoc Le
 * 
 */
public class Inversion extends UnaryFunction {

	/**
	 * Create a negation expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to negate
	 */
	public Inversion(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the negation of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the negation of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = -result.getRed();
		double green = -result.getGreen();
		double blue = -result.getBlue();

		return new RGBColor(red, green, blue);
	}

}
