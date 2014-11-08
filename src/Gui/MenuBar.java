package Gui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {

	//-----Members-----//
	JMenuBar menuBar;
	//-----Constructors-----//
	MenuBar() {
		initJMenu();
	}
		
	//-----Methods-----//
	
	//-----Utility Methods-----//
	protected void initJMenu() {
		//MenuBar
		menuBar = new JMenuBar();
		
		//Submenus
		JMenu file, simulation;
		file = new JMenu("File");
		simulation = new JMenu("Simulation");
		
		//File submenu items
		JMenuItem menuItem;
		menuItem = new JMenuItem("New");
		menuItem.setMnemonic(KeyEvent.VK_N);
		file.add(menuItem);
		
		menuItem = new JMenuItem("Load");
		menuItem.setMnemonic(KeyEvent.VK_L);
		file.add(menuItem);
		
		menuItem = new JMenuItem("Save");
		menuItem.setMnemonic(KeyEvent.VK_S);
		file.add(menuItem);
		
		//Simulation submenu items
		menuItem = new JMenuItem("Start");
		menuItem.setMnemonic(KeyEvent.VK_S);
		simulation.add(menuItem);
		
		menuItem = new JMenuItem("Stop");
		menuItem.setMnemonic(KeyEvent.VK_X);
		simulation.add(menuItem);
		
		menuItem = new JMenuItem("End");
		menuItem.setMnemonic(KeyEvent.VK_E);
		simulation.add(menuItem);
		
		menuBar.add(file);
		menuBar.add(simulation);
	}

	//-----Getters/Setters-----//
	/**
	 * Gets the menu bar that was previously constructed.
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
