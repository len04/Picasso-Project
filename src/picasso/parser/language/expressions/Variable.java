package picasso.parser.language.expressions;

import java.util.Map;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;
	// RGBColor RGB = res.getVar();
	private RGBColor rgb;
	
	public Variable(String name) {
		this.name = name;
		
	}	
	public Variable(String name, RGBColor rgb) {
		this.name = name;
		this.rgb = rgb;
		
	}


	@Override
	public RGBColor evaluate(double x, double y) {
		// RGBColor result = evaluate(x, y);
		double red = rgb.getRed();
		double green = rgb.getGreen();
		double blue = rgb.getBlue();

		return new RGBColor(red, green, blue);
		//return new RGBColor(RGB.getRed(), RGB.getGreen(), RGB.getBlue());		
	}

	public String getName() {
		return name;
	}

}
