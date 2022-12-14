package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the PerlinBW function in the Picasso language.
 * 
 * @author Petra Ilic
 */
public class PerlinBW extends ExpressionTreeNode {

	private ExpressionTreeNode x_param;
	private ExpressionTreeNode y_param;
	
	/**
	 * Create a PerlinBW expression that takes two parameters
	 * 
	 * @param x_param
	 * @param y_param
	 */
	public PerlinBW(ExpressionTreeNode x_param, ExpressionTreeNode y_param) {
		this.x_param = x_param;
		this.y_param = y_param;
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = x_param.evaluate(x, y);
		RGBColor result2 = y_param.evaluate(x, y);
		
		double c = ImprovedNoise.noise(result1.getRed() + 0.3, result2.getRed() + 0.3, 0);
		return new RGBColor(c,c,c);
	}

}
