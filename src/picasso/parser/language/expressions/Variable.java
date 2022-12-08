package picasso.parser.language.expressions;

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

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(RGB.getRed(), RGB.getGreen(), RGB.getBlue());		
	}

	public String getName() {
		return name;
	}

}
