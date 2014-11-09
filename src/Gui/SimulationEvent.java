/**
 * 
 */
package Gui;

import java.io.File;
import java.util.ArrayList;

import Engine.Body;

/**
 * @author Dexter
 *
 */
public interface SimulationEvent {
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 * @return 
	 */
	public ArrayList<Body> newSimulationEvent();
	
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 * @param selectedFile 
	 * @return
	 */
	public ArrayList<Body> loadSimulationEvent(File selectedFile);
	
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 * @return
	 */
	public void saveSimulationEvent(File selectedFile);
	
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 */
	public void startSimulationEvent();
	
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 */
	public void pauseSimulationEvent();
	
	/**
	 * 
	 * @author Dexter
	 * Nov 8, 2014
	 */
	public void stopSimulationEvent();
}
