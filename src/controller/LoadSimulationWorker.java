/**
 * 
 */
package controller;

import java.io.File;

import Engine.Engine;
import Gui.GUI;

/**
 * @author Dexter
 *
 */
public class LoadSimulationWorker extends Worker {

	//-----Members-----//
	private File inputFile;
	
	//-----Constructors-----//
	LoadSimulationWorker() {
		
	}
	
	LoadSimulationWorker(Engine engine, GUI gui) {
		super(engine, gui);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		engine.loadSimulation(inputFile);
		gui.updateBodies(engine.getBodies());
	}
	
	//-----Getters/Setters-----//

}
