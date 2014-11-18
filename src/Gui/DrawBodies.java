package Gui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import Engine.Body;
import javax.swing.JPanel;

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
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.setColor(Color.orange);
		
		for (int x = 0; x < bodies.size();x++)
		{
			//TODO tweak these coordinates to center the Bodies
			int a = (int) Math.round(bodies.get(x).getPositionX());
			int b = (int) Math.round(bodies.get(x).getPositionY());
			int c = (int) Math.round(bodies.get(x).getRadius());
			
			g.fillOval(a, b, c, c);
			//TODO draw gravity radius/ make window resizable
		}
	}
	void setBodies(ArrayList<Body> bodies){
		this.bodies = bodies;
	}
}
