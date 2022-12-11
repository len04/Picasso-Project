package picasso.view;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * Adds a button as a variable to the history panel
 * 
 * @author Fekry Mostafa
 * 
 */
public class Adder {

	static Map<String, String> VarToExp = new HashMap<String, String>();
	private JPanel panel;

	/**
	 * Create a button from a variable
	 * @param name 
	 * 
	 */
	public Adder(String name) {
		String text = Frame.getInput().getText();
		String exp = text.substring(text.lastIndexOf("=") + 1);
		VarToExp.put(name, exp);
		panel = Frame.getMyPane();		
		panel.removeAll();
		for (String key : VarToExp.keySet()) { 
		    String value = VarToExp.get(key);
	        JButton button = new JButton(key + ": " + value);
	        panel.add(button);
	    }
		panel.revalidate();
		panel.repaint();
		      }
}