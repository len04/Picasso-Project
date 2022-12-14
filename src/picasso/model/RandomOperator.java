package picasso.model;
import java.util.Arrays;

public class RandomOperator {

    static String[] operators = {"+","-","*","/"};

    
    public static String RandomOp(){


        int x = (int)(Math.random()*(4));

        return operators[x];
    }



    public static boolean isOp(String s){

         return Arrays.asList(operators).contains(s);

    }

}
