package picasso.model;

public class RandomFunction{

    static int x;

    public static String Random(){

        String[] expressions = {"sin","cos","tan","wrap","clamp"};
        x = (int)(Math.random()*(expressions.length));

        
        return expressions[x];
        
    }
}