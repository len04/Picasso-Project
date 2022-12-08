package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Image expression tree node in the Picasso language.
 * 
 * @author Petra Ilic
 */
public class Image extends ExpressionTreeNode {
	
	/**
	 * Create image expression that takes as a parameter the image name
	 * 
	 * @param imageName the string name of the image file, must be in the images folder
	 */
	private String name;
	private BufferedImage b_image;

	public Image(String imageName) {
		try {
			this.name = imageName;
			this.b_image = ImageIO.read(new File("images/"+ name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int scaleCoord(double val, int width) {
		return (int )((val+1)/2*(width-1));
	}

	/**
	 * Evaluates this image at the given x,y point by getting the color of the image
	 * at the inputed coordinates
	 * 
	 * @return the color from those coordinates
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		int x_coord = scaleCoord(x, b_image.getWidth());
		int y_coord = scaleCoord(y, b_image.getWidth());
		
		return new RGBColor(new Color(b_image.getRGB(x_coord, y_coord)));
	}

}
