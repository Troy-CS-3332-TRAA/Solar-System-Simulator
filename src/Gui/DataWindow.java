package Gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import Engine.Body;

public class DataWindow extends JFrame {

	//-----Members-----//
	private TableWindow myWindow;
	private MenuBar myBar;
	private ArrayList<Body> bodies;
	private Boolean initialized;
	private Controller controller;
	private GUI gui;
	
	//-----Constructors-----//
	DataWindow() {
	}

	public DataWindow(String dataWindowTitle, Controller controller, GUI gui) {
		super(dataWindowTitle);
		initialized = false;
	}
	
	DataWindow(String title, Controller controller, GUI gui, ArrayList<Body> bodies) throws HeadlessException {
		super(title);
		initDataWindow(controller, gui);
		this.bodies = bodies;
		this.controller = controller;
		this.gui = gui;
		initialized = true;
	}

	//-----Methods-----//
	void step(ArrayList<Body> bodies) {
		this.bodies = bodies;
		myWindow.updateTable(this.bodies);
	}
	
	public void updateBodies(ArrayList<Body> newSimulation) {
		bodies = newSimulation;
		myWindow.updateBodies(bodies);
	}
	
	public void initializeDataWindow(ArrayList<Body> bodies) {
		this.bodies = bodies;
		this.controller = controller;
		this.gui = gui;
		initDataWindow(controller, gui);
		
	}
	//-----Utility Methods-----//
	protected void initDataWindow(Controller controller, GUI gui) {
		myWindow = new TableWindow(bodies);
		this.add(myWindow);
		myBar = new MenuBar(((JPanel) myWindow), controller, gui);
		this.setJMenuBar(myBar.getMenuBar());
	}
	//-----Getters/Setters-----//

	/**
	 * @return true if it was constructed with a bodies list
	 */
	public Boolean isInitialized() {
		return initialized;
	}
}
