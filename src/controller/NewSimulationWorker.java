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
	Controller controller;
	//-----Constructors-----//
	/**
	 * 
	 * @author Dexter
	 * Nov 14, 2014
	 */
	NewSimulationWorker() {
		
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
		this.controller = controller;
	}
	
	//-----Methods-----//
	@Override
	public void run() {
		engine.newSimulation();
		gui.updateBodies(engine.getBodies());
		controller.startSimulationEvent();
	}

}
