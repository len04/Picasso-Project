package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the PerlinBW function in the Picasso language.
 * 
 * @author Petra Ilic
 */
public class PerlinBW extends BinaryOperator {

	/**
	 * Create an PerlinBW expression that takes as two parameters the given expression
	 * 
	 * @param param1 
	 * @param param2 
	 */
	public PerlinBW(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the perlin noise of
	 * the operations's parameters.
	 * 
	 * @return the shade (grey-scale) from evaluating the perlin noise of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		
		double c = ImprovedNoise.noise(result1.getRed() + 0.3, result2.getRed() + 0.3, 0);
	
		return new RGBColor(c, c, c);
	}

}
