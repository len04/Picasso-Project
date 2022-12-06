package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents the ImageClip function in the Picasso language.
 * 
 * @author Petra Ilic
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
		double new_x = Clamp.clamp(x);
		double new_y = Clamp.clamp(y);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/vortex.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		int clr = img.getRGB(new_x, new_y);
//      int red =   (clr & 0x00ff0000) >> 16;
//      int green = (clr & 0x0000ff00) >> 8;
//      int blue =   clr & 0x000000ff;
		
		return new RGBColor(red, green, blue);
	}

}
