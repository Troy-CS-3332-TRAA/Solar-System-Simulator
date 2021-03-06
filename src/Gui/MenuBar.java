package Gui;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.Controller;

import Engine.Body;

public class MenuBar {

	//-----Members-----//
	JMenuBar menuBar;
	SimulationEventNotifier notifier;
	//-----Constructors-----//
	MenuBar() {
	}
	MenuBar(JPanel panel, Controller controller, GUI gui){
		initJMenu(panel, controller, gui);
	}
		
	//-----Methods-----//
	
	//-----Utility Methods-----//
	protected void initJMenu(JPanel panel, Controller controller, GUI gui) {
		notifier = new SimulationEventNotifier(controller);
		
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
		menuItem.addActionListener(e -> {
			notifier.newSimulation();
		});
		file.add(menuItem);
		
		menuItem = new JMenuItem("Load");
		menuItem.setMnemonic(KeyEvent.VK_L);
		menuItem.addActionListener(e -> {
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(panel);
			File selectedFile = fc.getSelectedFile();
			notifier.loadSimulation(selectedFile);
		});
		file.add(menuItem);
		
		menuItem = new JMenuItem("Save");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(e -> {
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(panel);
			File selectedFile = fc.getSelectedFile();
			notifier.saveSimulation(selectedFile);
		});
		file.add(menuItem);
		
		//Simulation submenu items
		menuItem = new JMenuItem("Start");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(e -> {
			notifier.startSimulation();
		});
		simulation.add(menuItem);
		
		menuItem = new JMenuItem("Pause");
		menuItem.setMnemonic(KeyEvent.VK_X);
		menuItem.addActionListener(e -> {
			notifier.pauseSimulation();
		});
		simulation.add(menuItem);
		
		menuItem = new JMenuItem("Stop");
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener(e -> {
			notifier.stopSimulation();
		});
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
