package Gui;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.Body;

public class DrawBodies extends JPanel
{

	//-----Members-----//
	private ArrayList<Body> bodies;
	private ArrayList<JLabel> bodiesLabels;
	
	
	
	/**
	 * @author CharlesWomble
	 * This is the constructor for this class,
	 * @param bodies used to get information to draw shape.
	 */
	public DrawBodies (ArrayList <Body> bodies)
	{
		this.bodies = bodies;
		bodiesLabels = new ArrayList<JLabel>();
		for(Body body : bodies) {
			JLabel label = new JLabel(body.getName());
			label.setForeground(Color.WHITE);
			label.setFont(label.getFont().deriveFont(20f));
			bodiesLabels.add(label);
			add(label);
		}
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
		
		//Adds the 1/2 w/h of the window to make the center of the coordinate system the middle of the window
		int windowXOffset = getPreferredSize().width/2;
		int windowYOffset = getPreferredSize().height/2;
				
		for (int x = 0; x < bodies.size();x++) {
			int a = (int) bodies.get(x).getPositionX()*100 + (int) bodies.get(x).getRadius() + windowXOffset; //divide for scaling the distance between bodies
			int b = (int) bodies.get(x).getPositionY()*100 + (int) bodies.get(x).getRadius() + windowYOffset;
			int c = (int) (bodies.get(x).getRadius() * 100); //multiply and add for scaling of body sizes, allowing smaller bodies to be visible while not being completely dwarfed by larger ones 
			int labelX = a;
			int labelY = b - (int) bodiesLabels.get(x).getSize().getHeight();
			int labelH = (int) bodiesLabels.get(x).getSize().getWidth();
			int labelW = (int) bodiesLabels.get(x).getSize().getHeight();
			bodiesLabels.get(x).setBounds(a, labelY, labelH, labelW);
			
			if (x == 0) {
				g.setColor(Color.orange); //set first object in Bodies, the star, Orange
				g.fillOval((a), (b), c, c);
			}
			else {
				Random rand = new Random();
				float hue = rand.nextFloat();
				float sat = (rand.nextInt(2000) + 1000) / 10000f;
				float lum = 0.9f;
				Color color = Color.getHSBColor(hue, sat, lum); //create random colors for the other bodies in the ArrayList that do not blend with the background 
				g.setColor(color);
				g.fillOval((a), (b), c, c);
			}
			//TODO draw gravity radius
		}
	}

	void setBodies(ArrayList<Body> bodies){
		this.bodies = bodies;
	}
}
