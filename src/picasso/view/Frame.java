package picasso.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import picasso.model.Pixmap;
import picasso.util.NamedCommand;
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
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
		
		JLabel inputLabel = new JLabel ("Enter expression: ");
		JTextField inputField = new JTextField(10);
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));	
		
		commands.add(inputLabel);
		commands.add(inputField);	
		commands.add("Submit", new NamedCommand(canvas, new Evaluator()));			
		
		// inputField.addActionListener((ActionListener) this);

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		
		pack();
	}
}
