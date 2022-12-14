package picasso.model;
import java.util.Arrays;

public class RandomVariable {

    static String[] variables = {"x","y","x+y","x*y","x-y","x/y"};
    
    public static String RandomVar(){


        int x = (int)(Math.random()*(variables.length));


        return variables[x];
    }

    public static boolean isVar(String s){

        return Arrays.asList(variables).contains(s);

   }

}
