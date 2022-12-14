package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random function in the Picasso language.
 * 
 * @author Petra Ilic
 */
public class Random extends ExpressionTreeNode {

	private double red;
	private double green;
	private double blue;
	
	/**
	 * Create a Random expression that takes no parameters
	 */
	public Random() {
		this.red = Math.random()*randomSign();
		this.green = Math.random()*randomSign();
		this.blue = Math.random()*randomSign();
	}
	
	/**
	 * Randomly returns 1 or -1
	 * 
	 * @return 1 or -1, randomly
	 */
	public static double randomSign() {
		return (Math.pow(-1, Math.floor(Math.random()*10)));
	}

	/**
	 * Evaluates this image at the given x,y point by returning a random color
	 * 
	 * @returns random color, not dependent on x and y
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(red, green, blue);
	}

	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Random)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		// no parameters to check if equal
		
		return true;
	}
}
