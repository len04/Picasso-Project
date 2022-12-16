package picasso.model;
import java.util.Arrays;
/**
 * A helper function for Randomize that generates a random operator
 * 
 * @author Matt Stock
 *
 */

public class RandomOperator {

	static String[] operators = {"+","-","*","/"};

	public static String RandomOp(){


		int x = (int)(Math.random()*(operators.length));

		return operators[x];
	}



	public static boolean isOp(String s){

		return Arrays.asList(operators).contains(s);

	}

}
