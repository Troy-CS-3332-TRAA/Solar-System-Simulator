package launcher;
import java.util.ArrayList;

import Engine.Body;
import Engine.Engine;
import Gui.GUI;
import Gui.SplashScreen;
import controller.Controller;


public class Main {
	
	static boolean paused = false;
	static Engine engine;
	static GUI gui;
	static ArrayList<Body> bodies;
	
	public static void main(String[] args)  {
		new SplashScreen("Welcome", new Controller());
	}
}
