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
	
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.setColor(Color.orange);
		
		for (int x = 0; x > bodies.size();x++)
		{
			fillOval(bodies.get(x).getPositionX(), bodies.get(x).getPositionY(),
					bodies.get(x).getRadius(), bodies.get(x).getRadius() );
			//TODO draw gravity radius/ make window resizable
		}
	}
}
