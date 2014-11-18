package Gui;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Engine.Body;

public class DrawBodies extends JPanel
{

	//-----Members-----//
	ArrayList <Body> bodies;
	
	
	
	/**
	 * @author CharlesWomble
	 * This is the constructor for this class,
	 * @param bodies used to get information to draw shape.
	 */
	public DrawBodies (ArrayList <Body> bodies)
	{
		this.bodies = bodies;
	}
	
	
	/* 
	 * @author CharlesWomble
	 * This method paints all the bodies in the ArrayList
	 * ints a, b, & c are the double values of the positions
	 * and radius of the Body casted into ints to be used
	 * for fillOval (c is used twice because it is a circle and 
	 * width + height should be the same.
	 * @Graphics g (from java.awt.Graphics)
	 */
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);
		
		for (int x = 0; x < bodies.size();x++) {
			//TODO tweak these coordinates to center the Bodies
			int a = (int) (Math.round(bodies.get(x).getPositionX()) / 10000); //divide for scaling the distance between bodies
			int b = (int) (Math.round(bodies.get(x).getPositionY()) / 10000); 
			int c = (int) (Math.round(bodies.get(x).getRadius()) * 100 + 20); //multiply and add for scaling of body sizes, allowing smaller bodies to be visible while not being completely dwarfed by larger ones 
			
			if (x == 0) {
				g.setColor(Color.orange); //set first object in Bodies, the star, Orange
				g.fillOval((a - c), (b - c), c, c);
			}
			else {
				Random rand = new Random();
				float hue = rand.nextFloat();
				float sat = (rand.nextInt(2000) + 1000) / 10000f;
				float lum = 0.9f;
				Color color = Color.getHSBColor(hue, sat, lum); //create random colors for the other bodies in the ArrayList that do not blend with the background 
				g.setColor(color);
				g.fillOval((a - c), (b - c), c, c);
			}
			//TODO draw gravity radius/ make window resizable
		}
	}

	void setBodies(ArrayList<Body> bodies){
		this.bodies = bodies;
	}
}
