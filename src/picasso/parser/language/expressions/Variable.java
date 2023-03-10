package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.VariableException;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 * @author Fekry Mostafa
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;
	private ExpressionTreeNode root;
	private RGBColor result;
    static int recursionDepth = 0;

	public Variable(String name) {
		this.name = name;
		
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the expression of
	 * the variable
	 * 
	 * @return the color from evaluating the result of the variable
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
	    recursionDepth++;
		root = IdentifierAnalyzer.getID().get(name);
		if (recursionDepth > 1) {
			throw new VariableException(name);
			}
		result = root.evaluate(x, y);
		recursionDepth = 0;
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		return new RGBColor(red, green, blue);		
	}

	public String getName() {
		return name;
	}
	
}
