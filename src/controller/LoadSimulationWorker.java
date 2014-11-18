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
		gui.initWindows(engine.getBodies());
	}

	//-----Getters/Setters-----//
	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}
}
