package picasso.model;
/**
 * A helper function for Randomize that generates a random function
 * 
 * @author Matt Stock
 *
 */
public class RandomFunction{

	static int x;

	public static String Random(){

		String[] expressions = {"sin","cos","tan","wrap","clamp"};
		x = (int)(Math.random()*(expressions.length));
		return expressions[x];

	}
}