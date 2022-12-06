package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the wrap in the Picasso language.
 * 
 * @author Petra Ilic
 * 
 */
public class Wrap extends UnaryFunction {
	
	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Wraps double n around [-1,1]
	 * @param n double to wrap
	 * @return double result of wrapping n around [-1,1]
	 */
	public static double wrap(double n) {
		double result = 0;
		if (n>1) {
			result = (n % 2 - 2) % 1;
		}
		else if (n<-1) {
			n = Math.abs(n);
			result = -1*((n % 2 - 2) % 1);
		}
		else {
			result = n;
		}
		return result;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());

		return new RGBColor(red, green, blue);
	}
	
	public static void main(String args[]) {
		System.out.println(wrap(1.5));
		System.out.println(wrap(1.7));
		System.out.println(wrap(0.2));
		System.out.println(wrap(-2));
		System.out.println(wrap(-1.2));
	}
	

}
