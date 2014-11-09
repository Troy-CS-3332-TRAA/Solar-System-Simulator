package launcher;
import java.io.File;
import java.util.ArrayList;

import Engine.Body;
import Gui.SimulationEvent;
import Gui.SplashScreen;


public class Main implements SimulationEvent {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		new SplashScreen("Welcome", new Main());

	}

	@Override
	public ArrayList<Body> newSimulationEvent() {
		//TODO create new sim-engine and return the bodies list from it
		return null;
	}

	@Override
	public ArrayList<Body> loadSimulationEvent(File selectedFile) {
		// TODO load existing sim-engine and return the bodies list from it
		return null;
	}

	@Override
	public void saveSimulationEvent(File selectedFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startSimulationEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseSimulationEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopSimulationEvent() {
		// TODO Auto-generated method stub
		
	}
}
