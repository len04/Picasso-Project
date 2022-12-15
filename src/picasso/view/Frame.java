package picasso.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;



import picasso.model.Pixmap;
import picasso.model.Randomize;
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
	private static ArrayList<JButton> buttons = new ArrayList<JButton>();
	private static JButton Evaluate; 
	private static int clicked;	
	Action upAction;
	Action downAction;

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

		upAction = new UpAction();
		downAction = new DownAction();
		canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "upAction");
		canvas.getActionMap().put("upAction", upAction);	
		canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "downAction");
		canvas.getActionMap().put("downAction", downAction);			

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(inputLabel);
		commands.add(inputField);
		Evaluate = commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));

		commands.add("Save", new Writer());
		commands.add("Randomize", new Randomizer());
		commands.add(errorLabel);
		commands.add(errorField);
		setErrorField("");

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(myPane, BorderLayout.EAST);
		pack();		
	}

	public static void Adder() {
		String text = inputField.getText();
		int index = text.lastIndexOf("=");
		String exp = text.substring( index + 1);
		String name = text.substring(0, index);
		if (VarToExp.containsKey(name)) {
			System.out.println("TT1");
			if (VarToExp.get(name).equals(exp)) {
				System.out.println("TT");
				return;
			}
			removeButton(name + "=" + exp);
		}
		VarToExp.put(name, exp);
		JButton button = new JButton(name + "=" + exp);	
		myPane.add(button);
		BufferedImage img = canvas.getPixmap().getMyImage();
		Image newimg = img.getScaledInstance( 25, 25, Image.SCALE_SMOOTH) ;  	        
		button.setIcon(new ImageIcon(newimg));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicked = buttons.indexOf(button);
				inputField.setText(button.getText());
				Evaluate.doClick();
			}
		});
		buttons.add(button);
		myPane.revalidate();
		myPane.repaint();
	}

	private static void removeButton(String string) {
		Component[] components = myPane.getComponents();
		for (Component component : components) {
			String text = ((JButton) component).getText();
			if (text.startsWith(string.substring(0, 1))) {
				myPane.remove(component);
			}
		}
	}

	private class DownAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("DOWN");	
			if (clicked < buttons.size())
			{
				clicked += 1;        	
				JButton  upButton = buttons.get(clicked);
				inputField.setText(upButton.getText());
				Evaluate.doClick();          	
			}
		}
	}

	private class UpAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("UP");
			if (clicked > 0) { 
				clicked -= 1;
				JButton upButton = buttons.get(clicked);
				inputField.setText(upButton.getText());
				Evaluate.doClick();   
			}

		}
	}

	public static JTextField getInput() {
		return inputField;
	}

	public static void setInputField(String s){
		inputField.setText(s);
	}

	public static JTextField getErrorField() {
		return errorField;
	}

	public static JPanel getMyPane() {
		return myPane;
	}

}
