package controller;
import java.io.File;
import java.util.ArrayList;

import Engine.Body;
import Engine.Engine;
import Gui.GUI;
import Gui.SimulationEvent;


public class Controller implements SimulationEvent {
	
	private Engine engine;
	private GUI gui;
	private ArrayList<Body> bodies;
	private LoadSimulationWorker loadWorker;
	private SaveSimulationWorker saveWorker;
	private NewSimulationWorker newWorker;
	private SimulationWorker simulationWorker;
	
	
	public Controller() {
		initController();
	}

	private void initController() {
		engine = new Engine();
		gui = new GUI(this);
		simulationWorker = new SimulationWorker(engine, gui);
	}

	@Override
	public void newSimulationEvent() {
		newWorker = new NewSimulationWorker(engine, gui);
		newWorker.run();
	}

	@Override
	public void loadSimulationEvent(File selectedFile) {
		loadWorker = new LoadSimulationWorker(engine, gui);
		loadWorker.setInputFile(selectedFile);
		loadWorker.run();
	}

	@Override
	public void saveSimulationEvent(File selectedFile) {
		saveWorker = new SaveSimulationWorker(engine, gui);
		saveWorker.run();
		
	}

	@Override
	public void startSimulationEvent() {
		simulationWorker.setPaused(false);
		simulationWorker.run();
	}

	@Override
	public void pauseSimulationEvent() {
		simulationWorker.setPaused(true);
		
	}

	@Override
	public void stopSimulationEvent() {
		simulationWorker.setPaused(true);
		
	}
}
