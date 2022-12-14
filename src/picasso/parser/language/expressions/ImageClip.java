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
	 * evaluated and clamped coordinates of the of the inputed image
	 * 
	 * @returns color at evaluated coordinates of inputed image
	 */
	@Override
	public RGBColor evaluate(double x, double y) { 
		double new_x = Clamp.clamp(x_param.evaluate(x, y).getRed());
		double new_y = Clamp.clamp(y_param.evaluate(x, y).getRed());
				
		return image.evaluate(new_x, new_y);
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof ImageClip)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		ImageClip uf = (ImageClip) o;

		// check if their parameters are equal
		if (!this.image.equals(uf.image)) {
			return false;
		}
		
		if (!this.x_param.equals(uf.x_param)) {
			return false;
		}
		
		if (!this.y_param.equals(uf.y_param)) {
			return false;
		}
		
		return true;
	}

}
