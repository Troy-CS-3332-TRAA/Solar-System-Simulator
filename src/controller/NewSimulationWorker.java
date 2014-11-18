package controller;

import Engine.Engine;
import Gui.GUI;

/**
 * 
 * @author Dexter Parks
 *
 */
public class NewSimulationWorker extends Worker {

	//-----Members-----//

	//-----Constructors-----//
	/**
	 * 
	 * @author Dexter
	 * Nov 14, 2014
	 */
	NewSimulationWorker() {
		super();
	}
	
	/**
	 * 
	 * @author Dexter Parks
	 * Nov 14, 2014
	 * @param engine
	 * @param gui
	 */
	NewSimulationWorker(Engine engine, GUI gui) {
		super(engine, gui);
	}
	
	//-----Methods-----//
	@Override
	public void run() {
		engine.newSimulation();
		gui.initWindows(engine.getBodies());
	}

}
