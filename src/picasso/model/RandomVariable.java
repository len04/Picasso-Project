package picasso.model;
import java.util.Arrays;

public class RandomVariable {

    static String[] variables = {"x","y"};
    
    public static String RandomVar(){


        int x = (int)(Math.random()*(2));


        return variables[x];
    }

    public static boolean isVar(String s){

        return Arrays.asList(variables).contains(s);

   }

}
