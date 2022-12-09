package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;
	private ExpressionTreeNode root;
	private RGBColor result;
	
	public Variable(String name) {
		this.name = name;
		
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		root = IdentifierAnalyzer.getID().get(name);
		result = root.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		return new RGBColor(red, green, blue);		
	}

	public String getName() {
		return name;
	}
	
}
