package Gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import launcher.Main;
import Engine.Body;

public class DataWindow extends JFrame {

	//-----Members-----//
	private TableWindow myWindow;
	private MenuBar myBar;
	private ArrayList<Body> bodies;
	
	//-----Constructors-----//
	DataWindow() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	DataWindow(String title, Main main, GUI gui, ArrayList<Body> bodies) throws HeadlessException {
		super(title);
		initDataWindow(main, gui);
		this.bodies = bodies;
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
	
	//-----Utility Methods-----//
	protected void initDataWindow(Main main, GUI gui) {
		myWindow = new TableWindow(bodies);
		this.add(myWindow);
		myBar = new MenuBar(((JPanel) myWindow), main, gui);
		this.setJMenuBar(myBar.getMenuBar());
	}
	
	//-----Getters/Setters-----//

}
