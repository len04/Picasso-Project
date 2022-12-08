package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;


/**
 * Represents the ImageClip function in the Picasso language.
 * 
 * @author Petra Ilic
 */
public class ImageClip extends ExpressionTreeNode { 
	
	private Image image;
	private ExpressionTreeNode x_param;
	private ExpressionTreeNode y_param;

	/**
	 * Create an ImageClip expression that takes three parameters
	 * 
	 * @param param1 string name of the image
	 * @param param2 the x coordinate expression
	 * @param param3 the y coordinate expression
	 */
	public ImageClip(Image image, ExpressionTreeNode x_param, ExpressionTreeNode y_param) {
		this.image = image;
		this.x_param = x_param;
		this.y_param = y_param;
	}
	
	
	/**
	 * Evaluates this image at the given x,y point by getting the color at the 
	 * evaluated and clamped coordinated of the of the inputed image
	 * 
	 * @returns color at evaluated coordinates of inputed image
	 */
	@Override
	public RGBColor evaluate(double x, double y) { 
		double new_x = Clamp.clamp(x_param.evaluate(x, y).getRed());
		double new_y = Clamp.clamp(y_param.evaluate(x, y).getRed());
				
		return image.evaluate(new_x, new_y);
	}

}
