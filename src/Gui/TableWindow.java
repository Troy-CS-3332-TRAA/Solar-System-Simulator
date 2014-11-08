package Gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import Engine.Body;

public class TableWindow extends JPanel {

	//-----Members-----//
	private JTable table;
	private ArrayList<Body> bodies;
	
	//-----Constructors-----//
	public TableWindow() {
		// TODO Auto-generated constructor stub
		initTableWindow();
	}
	
	public TableWindow(ArrayList<Body> bodies) {
		this.bodies = bodies;
		initTableWindow();
	}
	
	//-----Methods-----//
	
	//-----Utility Methods-----//
	protected void initTableWindow() {
		table = new JTable(new BodyTableModel(bodies));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	}
	
	//-----Getters/Setters-----//

}
