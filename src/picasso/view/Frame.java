package picasso.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
import picasso.parser.*;
import picasso.parser.tokens.Token;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	JTextField inputField;	
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
		
		JTextField newTitle = new JTextField("Champions");		
		this.setTitle(newTitle.getText());		
		
		JLabel inputLabel = new JLabel ("Enter expression: ");
		inputField = new JTextField(10);
		JButton submit = new JButton("submit");
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));	
		
		commands.add(inputLabel);
		commands.add(inputField);
		commands.add(submit);
		submit.addActionListener(this);

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
        if (s.equals("submit")) {
        	Tokenizer tokenizer = new Tokenizer();
        	List<Token> l = tokenizer.parseTokens(inputField.getText());
			System.out.println(l);
            inputField.setText("");

        }
	}
}
