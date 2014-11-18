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
public abstract class Worker extends Thread {
	
	
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
}
