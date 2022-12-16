package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the clamp function in the Picasso language.
 * 
 * @author Matt Stock
 */
public class Clamp extends UnaryFunction {

	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	public static double clamp(double n) {
		double result = 0;
		if (n > 1) {
			result = 1;
		}
		else if (n < -1) {
			result = -1;
		}
		else {
			result = n;
		}
		return result;
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the clamp of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the clamp of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = clamp(result.getRed());
		double green = clamp(result.getGreen());
		double blue = clamp(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
