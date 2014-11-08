package Gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;

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

	DataWindow(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	DataWindow(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	DataWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	//-----Methods-----//
	void step(ArrayList<Body> bodies) {
		this.bodies = bodies;
	}
	
	//-----Utility Methods-----//
	protected void initDataWindow() {
		myWindow = new TableWindow(bodies);
		this.add(myWindow);
		myBar = new MenuBar();
		this.setJMenuBar(myBar.getMenuBar());
	}
	
	//-----Getters/Setters-----//

}
