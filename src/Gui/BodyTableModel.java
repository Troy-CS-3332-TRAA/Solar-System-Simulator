package Gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Engine.Body;

public class BodyTableModel extends AbstractTableModel {
	
	//-----Members-----//
	private ArrayList<Body> bodies;
	private String[] columnNames = {"Name","Pos X",	"Pos Y","Radius", "Mass", "Distance From Star", "Star"};
	
	
	//-----Constructors-----//
	BodyTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	BodyTableModel(ArrayList<Body> bodies) {
		this.bodies = bodies;
	}

	//-----Methods-----//
	@Override
	public int getRowCount() {
		return bodies.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return bodies.get(rowIndex).getName();
		} else if(columnIndex == 1) {
			return bodies.get(rowIndex).getPositionX();
		} else if(columnIndex == 2) {
			return bodies.get(rowIndex).getPositionY();
		} else if(columnIndex == 3) {
			return bodies.get(rowIndex).getRadius();
		} else if(columnIndex == 4) {
			return bodies.get(rowIndex).getMass();
		} else if(columnIndex == 5) {
			return bodies.get(rowIndex).getDistanceFromStar();
		} else if(columnIndex == 6) {
			return bodies.get(rowIndex).isStar();
		}
		return null;
	}

	//-----Utility Methods-----//
	
	//-----Getters/Setters-----//
	/**
	 * @param bodies the bodies to set
	 */
	public BodyTableModel setBodies(ArrayList<Body> bodies) {
		this.bodies = bodies;
		return this;
	}
}
