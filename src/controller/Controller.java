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
		new Thread(newWorker).start();
	}

	@Override
	public void loadSimulationEvent(File selectedFile) {
		loadWorker = new LoadSimulationWorker(engine, gui);
		loadWorker.setInputFile(selectedFile);
		new Thread(loadWorker).start();
	}

	@Override
	public void saveSimulationEvent(File selectedFile) {
		saveWorker = new SaveSimulationWorker(engine, gui);
		new Thread(saveWorker).start();
		
	}

	@Override
	public void startSimulationEvent() {
		simulationWorker.setPaused(false);
		new Thread(simulationWorker).start();
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
