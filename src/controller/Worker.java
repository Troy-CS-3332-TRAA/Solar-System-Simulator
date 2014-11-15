/**
 * 
 */
package controller;

import java.util.ArrayList;

import Engine.Body;
import Engine.Engine;
import Gui.GUI;

/**
 * @author Dexter
 *
 */
public class Worker implements Runnable {
	
	
	//-----Members-----/
	protected ArrayList<Body> bodies;
	protected Engine engine;
	protected GUI gui;
	
	Worker() {
		
	}
	
	Worker(Engine engine, GUI gui) {
		this.engine = engine;
		this.gui = gui;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
