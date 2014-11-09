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
public class SimulationEventNotifier {
	
	SimulationEvent event;
	
	SimulationEventNotifier(SimulationEvent event) {
		this.event = event;
	}
	
	public ArrayList<Body> newSimulation() {
		return event.newSimulationEvent();
	}

	public ArrayList<Body> loadSimulation(File selectedFile) {
		return event.loadSimulationEvent(selectedFile);
	}

	public void saveSimulation(File selectedFile) {
		event.saveSimulationEvent(selectedFile);
	}

	public void startSimulation() {
		event.startSimulationEvent();
		
	}

	public void pauseSimulation() {
		event.pauseSimulationEvent();
	}
	public void stopSimulation() {
		event.stopSimulationEvent();
		
	}

}
