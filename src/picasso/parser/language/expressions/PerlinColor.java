package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Perlin Color function in the Picasso language.
 * 
 * @author Ngoc Le
 * 
 */
public class PerlinColor extends BinaryOperator {

	/**
	 * Create an Perlin Color expression that takes as two parameters the given expression
	 * 
	 * @param param the expression to Perlin Color
	 */
	public PerlinColor(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the Perlin Color of
	 * the operations's parameters.
	 * 
	 * @return the color from evaluating the Perlin Color of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		
		double red = ImprovedNoise.noise(result1.getRed() + 0.3, result2.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(result1.getBlue() + 0.1, result2.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(result1.getGreen() - 0.8, result2.getGreen() - 0.8, 0);

		return new RGBColor(red, green, blue);
	}

}
