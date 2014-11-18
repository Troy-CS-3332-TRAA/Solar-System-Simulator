/**
 * 
 */
package controller;

import java.util.ArrayList;

import Engine.Body;
import Engine.Engine;
import Gui.GUI;

/**
 * @author Dexter Parks
 *
 */
public class SimulationWorker extends Worker {

	private Boolean paused;
	private Boolean crashed;
	
	
	SimulationWorker() {
		super();
	}
	
	SimulationWorker(Engine engine, GUI gui) {
		super(engine, gui);
		paused  = true;
		crashed = false;
	}
	
	void simulate() {
		while(!paused && !crashed) {
			engine.step();
			crashed = engine.getCollision();
			bodies = engine.getBodies();
			gui.step(bodies);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		simulate();

	}

	/**
	 * @return the paused
	 */
	public Boolean getPaused() {
		return paused;
	}

	/**
	 * @param paused the paused to set
	 */
	public void setPaused(Boolean paused) {
		this.paused = paused;
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	/**
	 * @return the gui
	 */
	public GUI getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUI gui) {
		this.gui = gui;
	}

}
