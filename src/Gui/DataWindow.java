package Gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Engine.Body;
import controller.Controller;

public class DataWindow extends JFrame {

	//-----Members-----//
	private TableWindow tableWindow;
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
		this.controller = controller;
		this.gui = gui;
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
		tableWindow.updateTable(this.bodies);
	}
	
	public void updateBodies(ArrayList<Body> newSimulation) {
		bodies = newSimulation;
		tableWindow.updateBodies(bodies);
	}
	
	public void initializeDataWindow(ArrayList<Body> bodies) {
		this.bodies = bodies;
		this.controller = controller;
		this.gui = gui;
		initDataWindow(controller, gui);
		
	}
	//-----Utility Methods-----//
	protected void initDataWindow(Controller controller, GUI gui) {
		tableWindow = new TableWindow(bodies);
		this.add(tableWindow);
		myBar = new MenuBar(((JPanel) tableWindow), controller, gui);
		this.setJMenuBar(myBar.getMenuBar());
		this.setPreferredSize(new Dimension(500,500));
	}
	//-----Getters/Setters-----//

	/**
	 * @return true if it was constructed with a bodies list
	 */
	public Boolean isInitialized() {
		return initialized;
	}
}
