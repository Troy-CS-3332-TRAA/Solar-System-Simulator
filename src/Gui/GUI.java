package Gui;

import java.util.ArrayList;

import controller.Controller;
import Engine.Body;

public class GUI {
    //-----Members-----
	private DataWindow dataWindow;
	private ArrayList<Body> bodies;
	
	//-----Constructors-----
	/**
	 * Creates the gui object with two frames. One frame is a window providing a visualization
	 * of the system. The other frame is a window showing the raw data.
	 * @author Dexter
	 * Nov 6, 2014
	 */
	public GUI() {
		//TODO Implement default constructor
	}
	/**
	 * Creates the gui object with two frames. One frame is a window providing a visualization
	 * of the system. The other frame is a window showing the raw data.
	 * @author Dexter
	 * Nov 6, 2014
	 * @param bodies The initial ArrayList of body objects that provide the updated data.
	 */
	public GUI(ArrayList<Body> bodies, Controller controller) {
		this.bodies = bodies;
		dataWindow = new DataWindow("Solar System Data", controller, this, bodies);
		
	}
	
	//-----Methods-----
	/**
	 * Updates the two windows with the most recent data
	 * @author Dexter
	 * Nov 6, 2014
	 * @param bodies The ArrayList of body objects that provide the updated data.
	 * @return True if there were no errors and false if it failed.
	 */
	public boolean step(ArrayList<Body> bodies) {
		dataWindow.step(bodies);
		return true;
	}
	
	public void updateBodies(ArrayList<Body> newSimulation) {
		bodies = newSimulation;
		dataWindow.updateBodies(bodies);
		//TODO VisualWindow.updateBodies(bodies);
	}
	
	//-----Utility Methods-----
	
	//-----Getters/Setters-----
}

