package picasso.model;
import java.util.Arrays;

/**
 * A helper function for Randomize that generates a random variable
 * 
 * @author Matt Stock
 *
 */
public class RandomVariable {

	static String[] variables = {"x","y","x+y","x*y","x-y","x/y","y-x","y/x"};

	public static String RandomVar(){


		int x = (int)(Math.random()*(variables.length));


		return variables[x];
	}

	public static boolean isVar(String s){

		return Arrays.asList(variables).contains(s);

	}

}
