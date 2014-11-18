/**
 * 
 */
package Gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

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
	}

	/**
	 * @author Dexter
	 * Nov 8, 2014
	 * @param arg0
	 * @param main 
	 * @throws HeadlessException
	 */
	public SplashScreen(String arg0, Controller controller) throws HeadlessException {
		super(arg0);
		initSplashScreen(controller);
		this.setVisible(true);
	}
	
	protected void initSplashScreen(Controller controller) {
		JPanel panel = new JPanel();
		JButton newButton = new JButton("New");
		JButton loadButton = new JButton("Load");
		SimulationEventNotifier notifier = new SimulationEventNotifier(controller);
		
		newButton.addActionListener(e -> {
			notifier.newSimulation();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		});
		
		loadButton.addActionListener(e -> {
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			File selectedFile = fc.getSelectedFile();
			notifier.loadSimulation(selectedFile);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		});
		
		panel.add(newButton);
		panel.add(loadButton);
		this.add(panel);
		this.setPreferredSize(new Dimension(200,75));
		this.pack();
	}

}
