package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class Reader extends FileCommand<Pixmap> {

	/**
	 * Creates a Reader object, which prompts users for image files to open
	 */
	public Reader() {
		super(JFileChooser.OPEN_DIALOG);
	}

	/**
	 * Displays the image file on the given target.
	 */
	public void execute(Pixmap target) {
		String fileName = getFileName();
		System.out.println(fileName);
	    int index = fileName.lastIndexOf('.');
	    String extension = fileName.substring( index+1);
	    System.out.println(extension);
		if (fileName != null) {
			if (extension.equals("png") || extension.equals("jpg")) {
				System.out.println("sucess");
				target.read(fileName);
			}
			else if (extension.equals("exp")) {
				System.out.println();
			}
		}
	}
}
