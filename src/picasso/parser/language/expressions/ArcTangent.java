package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the arc tan function in the Picasso language.
 * 
 * @author Petra Ilic
 *
 */
public class ArcTangent extends UnaryFunction {

	/**
	 * Create a arc tan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to arc tan
	 */
	public ArcTangent(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the arc tan of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the arc tan of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
