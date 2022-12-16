package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.IdentifierAnalyzer;
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
	 * Create a assignment expression that takes as two parameters the given expression and the string
	 * 
	 * @param param the expression to assign
	 */
	public Assignment(String name, ExpressionTreeNode param) {
		this.expression = param; 
		IdentifierAnalyzer.idToExpression.put(name, param);
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
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Assignment)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		Assignment uf = (Assignment) o;

		// check if their parameters are equal
		if (!this.expression.equals(uf.expression)) {
			return false;
		}
		return true;
	}
	
}
