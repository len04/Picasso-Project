package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create GUI components
		canvas = new Canvas(this);
		canvas.setSize(size);
	
		// changing title of window
		JTextField newTitle = new JTextField("Champions");		
		this.setTitle(newTitle.getText());		
		
		
		JLabel inputLabel = new JLabel ("Enter expression: ");
		inputField = new JTextField(10);
		JButton evaluate = new JButton("Evaluate");		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(inputLabel);
		commands.add(inputField);
		commands.add(evaluate);
		commands.add("Save", new Writer());
		

		evaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, new Evaluator());									
				action.execute(canvas.getPixmap());
				canvas.refresh();
				// inputField.setText("");
				}
		});
		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		pack();
	
	}

	public static String getInput() {
		return inputField.getText();
	}
}
