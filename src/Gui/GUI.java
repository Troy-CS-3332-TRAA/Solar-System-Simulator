package Gui;
import java.util.ArrayList;

import Engine.Body;

public class GUI {
    //-----Members-----
	private DataWindow dataWindow;
	
	//-----Constructors-----
	/**
	 * Creates the gui object with two frames. One frame is a window providing a visualization
	 * of the system. The other frame is a window showing the raw data.
	 * @author Dexter
	 * Nov 6, 2014
	 */
	public GUI() {
		//TODO Implement default constructor
		dataWindow = new DataWindow("Solar System Data");
	}
	/**
	 * Creates the gui object with two frames. One frame is a window providing a visualization
	 * of the system. The other frame is a window showing the raw data.
	 * @author Dexter
	 * Nov 6, 2014
	 * @param bodies The initial ArrayList of body objects that provide the updated data.
	 */
	public GUI(ArrayList<Body> bodies) {
		//TODO Implement constructor
	}
	
	//-----Methods-----
	/**
	 * Updates the two windows with the most recent data
	 * @author Dexter
	 * Nov 6, 2014
	 * @param bodies The ArrayList of body objects that provide the updated data.
	 * @return True if there were no errors and false if it failed.
	 */
	boolean step(ArrayList<Body> bodies) {
		dataWindow.step(bodies);
		return true;
	}
	
	//-----Utility Methods-----
	
	//-----Getters/Setters-----
}