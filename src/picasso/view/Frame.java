package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	private static Canvas canvas;
	private static JTextField inputField;	
	public static JTextField errorField;
	private static JPanel myPane;
	private static Map<String, String> VarToExp = new HashMap<String, String>();	
	private static JButton Evaluate; 

	public static void setErrorField(String s) {
		errorField.setText(s);
	}
	
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create GUI components
		canvas = new Canvas(this);
		canvas.setSize(size);
		
		// changing title of window
		JTextField newTitle = new JTextField("Champions");		
		this.setTitle(newTitle.getText());		
		
		JLabel errorLabel = new JLabel("Error: ");
		JLabel inputLabel = new JLabel ("Enter expression: ");
		errorField = new JTextField (10);
		inputField = new JTextField(10);	
		errorField.setEditable(false);
		
        myPane = new JPanel();
        myPane.setSize(500, 200);
        myPane.setLayout(new BoxLayout(myPane, BoxLayout.Y_AXIS));  
        myPane.setVisible(true);
        
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(inputLabel);
		commands.add(inputField);
		Evaluate = commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());
		commands.add(errorLabel);
		commands.add(errorField);
		setErrorField("");
		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(myPane, BorderLayout.EAST);
		pack();
	}
	
	public static void Adder(String name) {
		String text = inputField.getText();
		String exp = text.substring(text.lastIndexOf("=") + 1);
		VarToExp.put(name, exp);
		myPane.removeAll();
		for (String key : VarToExp.keySet()) { 
		    String value = VarToExp.get(key);
	        JButton button = new JButton(key + " = " + value);
	        myPane.add(button);
	        BufferedImage img = canvas.getPixmap().getMyImage();
	        Image newimg = img.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH) ;  	        
	        button.setIcon(new ImageIcon(newimg));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inputField.setText(button.getText());
					Evaluate.doClick();
					}
				});
		}
		myPane.revalidate();
		myPane.repaint();
	}

	public static JTextField getInput() {
		return inputField;
	}

	public static JTextField getErrorField() {
		return errorField;
	}

	public static JPanel getMyPane() {
		return myPane;
	}
}

