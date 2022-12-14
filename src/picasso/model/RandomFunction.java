package picasso.model;

public class RandomFunction{

    static int x;

    public static String Random(){

        x = (int)(Math.random()*(3));

        String[] expressions = {"sin","cos","tan"};
        return expressions[x];
        
    }
}