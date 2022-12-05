package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageClip function in the Picasso language.
 * 
 */
public class ImageClip extends MultiArgFunction {

	/**
	 * Create an ImageClip expression that takes three parameters
	 * 
	 * @param param1 string name of the image
	 * @param param2 the x coordinate expression
	 * @param param3 the y coordinate expression
	 */
	public ImageClip(ExpressionTreeNode param1, ExpressionTreeNode param2, ExpressionTreeNode param3) {
		super(param1, param2, param3);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return new RGBColor(1,-1,1);
	}

}
