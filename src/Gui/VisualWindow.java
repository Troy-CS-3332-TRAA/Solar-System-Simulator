package Gui;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Engine.Body;

public class VisualWindow extends JFrame
{
	//-----members-----//
	private ArrayList <Body> bodies;
	DrawBodies dB;
	//TODO add the JPanel from the DrawBodies class to this JFrame class
    
	//-----methods----//
	 VisualWindow(String title){
		 super(title);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 this.getContentPane().add(new MouseScroll().makeUI());
		 dB = new DrawBodies(bodies);
		 this.add(dB);
		 this.getContentPane().add(new DrawBodies(bodies));
		 this.setVisible(true);
	 }
	 void step (ArrayList<Body> bodies){
		 this.bodies = bodies;
		 dB.setBodies(bodies);
		 dB.repaint();
	 }
	
	
}