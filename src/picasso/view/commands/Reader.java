package picasso.view.commands;

import javax.swing.JFileChooser;
import java.io.*;
import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;


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
		if (fileName != null) {		
		    int index = fileName.lastIndexOf('.');
		    String extension = fileName.substring( index+1);
			if (extension.equals("png") || extension.equals("jpg")) {
				target.read(fileName);
			}
			else if (extension.equals("exp")) {
				try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
					String line;					
					while ((line = br.readLine()) != null) {
					    if (line.contains("//")) {
					      continue;
					    }
					    Frame.getInput().setText(line);
					    }

				} 
				catch (IOException e) {
				e.printStackTrace();
				}			
			}
		}
	}
}
