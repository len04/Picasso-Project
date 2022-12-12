package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exponential function in the Picasso language.
 * 
 * @author Petra Ilic
 *
 */
public class Exponential extends UnaryFunction {

	/**
	 * Create a exponential expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to raise as a power of e
	 */
	public Exponential(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by raising the parameter 
	 * as a power of e
	 * 
	 * @return the color from evaluating e to the power of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
