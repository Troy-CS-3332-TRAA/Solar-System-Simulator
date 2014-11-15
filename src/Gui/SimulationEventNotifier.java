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
	
	public void newSimulation() {
		event.newSimulationEvent();
	}

	public void loadSimulation(File selectedFile) {
		event.loadSimulationEvent(selectedFile);
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
