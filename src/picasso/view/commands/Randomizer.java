package picasso.view.commands;

import javax.swing.JFileChooser;
import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;
import picasso.model.Randomize;


/**
 * Generate random expression
 * 
 * @author Matt Stock
 */
public class Randomizer extends FileCommand<Pixmap> {

	/**
	 * Creates random image
	 */
	public Randomizer() {
		super(JFileChooser.OPEN_DIALOG);
	}

	/**
	 * Displays the image file on the given target.
	 */
	public void execute(Pixmap target) {

        String expression = Randomize.rand();
        Frame.setInputField(expression);

    }
}
