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
public class SaveSimulationWorker extends Worker {

	//-----Members-----//
	private File outputFile;
	
	//-----Constructors-----//
	SaveSimulationWorker() {
		super();
	}
	
	SaveSimulationWorker(Engine engine, GUI gui) {
		super(engine, gui);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		engine.saveSimulation(outputFile);
	}
	
	//-----Getters/Setters-----//

}
