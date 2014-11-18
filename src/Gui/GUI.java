package Gui;
import java.util.ArrayList;

import controller.Controller;

import Engine.Body;

public class GUI {
    //-----Members-----
	private DataWindow dataWindow;
	private VisualWindow visualWindow;
	private ArrayList<Body> bodies;
	private static final String DATAWINDOWTITLE = "Solar System Data";
	private static final String VISUALWINDOWTITLE = "Solar System GFX";
	
	//-----Constructors-----
	/**
	 * Creates the gui object with two frames. One frame is a window providing a visualization
	 * of the system. The other frame is a window showing the raw data.
	 * @author Dexter
	 * Nov 6, 2014
	 */
	public GUI() {
	}
	
	public GUI(Controller controller) {
		dataWindow = new DataWindow(DATAWINDOWTITLE, controller, this);
		visualWindow = new VisualWindow(VISUALWINDOWTITLE);
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
		dataWindow = new DataWindow(DATAWINDOWTITLE, controller, this, bodies);
		visualWindow = new VisualWindow(VISUALWINDOWTITLE);
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
		visualWindow.step(bodies);
		return true;
	}
	
	public void updateBodies(ArrayList<Body> newSimulation) {
		bodies = newSimulation;
		dataWindow.updateBodies(bodies);
		//VisualWindow.updateBodies(bodies);
	}

	public void initWindows(ArrayList<Body> bodies) {
		this.bodies = bodies;
		dataWindow.initializeDataWindow(bodies);
		visualWindow.initVisualWindow(bodies);
		
	}
	
	//-----Utility Methods-----
	
	//-----Getters/Setters-----
}
