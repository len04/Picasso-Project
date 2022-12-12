package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.IdentifierAnalyzer;
import picasso.view.*;
/**
 * Represents the assignment operation in the Picasso language.
 * 
 * @author Fekry Mostafa
 * 
 */
public class Assignment extends ExpressionTreeNode {

	private RGBColor result;
	private ExpressionTreeNode expression;

	/**
	 * Create a assignment expression that takes as two parameters the given expression
	 * 
	 * @param param the expression to equals
	 */
	public Assignment(String name, ExpressionTreeNode param2) {
		this.expression = param2; 
		IdentifierAnalyzer.getID().put(name, param2);
		Frame.Adder(name);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the assignment of
	 * the operation's parameters.
	 * 
	 * @return the color from evaluating the assignment of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		result = expression.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		return new RGBColor(red, green, blue);		
	}
	
}
