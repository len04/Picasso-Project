package picasso.model;

/**
 * Randomizes an expression and returns it
 * 
 * @author Matt Stock
 *
 */
public class Randomize {

	static int count = 0;
	static int maxIterations = 35;
	static int minIterations = 5;
	static int iterations = (int)(Math.random()*(maxIterations-minIterations+1)+minIterations);
	static String result = "";
	static String endChar;
	static int bigExp = 0;    

	public static String rand(){
		while(count < iterations){
			generateExp();
			count++;
		}
		count = 0;
		String temp = result;
		result = "";
		iterations = (int)(Math.random()*(maxIterations-minIterations+1)+minIterations);
		return temp;
	}


	public static void generateExp(){

		int big = (int)(Math.random()*(2));
		// used to determine if function is applied over whole expression

		// makes sure there's an operator between variables
		if (big != bigExp && result.length()!=0){
			endChar = result.substring(result.length()-1);
			if (RandomVariable.isVar(endChar))
				result += RandomOperator.RandomOp();
		}

		// apply function to whole expression
		if (big == bigExp && result.length()!=0)
			result = RandomFunction.Random() + "(" + result + ")" + RandomOperator.RandomOp();

		// main functions
		result += RandomFunction.Random() + "(" + RandomVariable.RandomVar() + ")" + RandomOperator.RandomOp() + RandomVariable.RandomVar();
	}

	public String getExpression(){
		return result;
	}




}
