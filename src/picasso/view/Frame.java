package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
	private Canvas canvas;
	private static JTextField inputField;	
	public static JTextField errorField;

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
		errorField = new JTextField (25);
		inputField = new JTextField(20);	
		// JButton evaluate = new JButton("Evaluate");		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(inputLabel);
		commands.add(inputField);
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());
		commands.add(errorLabel);
		commands.add(errorField);
		setErrorField("");
		
		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		pack();
	}

	public static JTextField getInput() {
		return inputField;
	}

	public static JTextField getErrorField() {
		return errorField;
	}
}

