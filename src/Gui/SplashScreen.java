/**
 * 
 */
package Gui;

import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dexter
 *
 */
public class SplashScreen extends JFrame {

	/**
	 * @author Dexter
	 * Nov 8, 2014
	 * @throws HeadlessException
	 */
	public SplashScreen() throws HeadlessException {
		initSplashScreen();
	}

	/**
	 * @author Dexter
	 * Nov 8, 2014
	 * @param arg0
	 * @throws HeadlessException
	 */
	public SplashScreen(String arg0) throws HeadlessException {
		super(arg0);
		initSplashScreen();
		this.setVisible(true);
	}
	
	protected void initSplashScreen() {
		JPanel panel = new JPanel();
		JButton newButton = new JButton("New");
		JButton loadButton = new JButton("Load");
		
		newButton.addActionListener(e -> {
			//TODO callback method for new simulation
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		});
		
		loadButton.addActionListener(e -> {
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			File selectedFile = fc.getSelectedFile();
			//TODO callback method for load simulation
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		});
		
		panel.add(newButton);
		panel.add(loadButton);
		this.add(panel);
		this.pack();
	}

}
