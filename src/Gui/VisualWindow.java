package Gui;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.WindowConstants;

import Engine.Body;

public class VisualWindow extends JFrame{
	//-----members-----//
	private ArrayList <Body> bodies;
	private float scale = 1;
	DrawBodies dB;
	//TODO add the JPanel from the DrawBodies class to this JFrame class
    
	//-----methods----//
	 VisualWindow(String title, ArrayList<Body> bodies){
		 super(title);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 this.setPreferredSize(new Dimension(500,500));
		 initVisualWindow(bodies);
		 setVisible(true);
	 }
	 /*
	  * Default constructor lacking bodies information.
	  */
	 VisualWindow(String title){
		 super(title);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 this.setPreferredSize(new Dimension(500,500));
		 setVisible(true);
	 }
	 /*
	  * Can be called to create a new DrawBodies instance and then add that panel to the frame. 
	  */
	 void initVisualWindow(ArrayList<Body> bodies){
		 dB = new DrawBodies(bodies);
		 MouseListener mouseListner = new MouseListener(dB);
		 final JScrollPane scrollPane = new JScrollPane(dB);
		 //TODO This dimension needs to be as large as the distance of the objects represented
		 dB.setPreferredSize(new Dimension(2000,2000));
		 scrollPane.getViewport().addMouseListener(mouseListner);
		 scrollPane.getViewport().addMouseMotionListener(mouseListner);
		 
		 this.add(scrollPane);
	 }
	 /*
	  * Used by controller to interactively update information and redraw the system. 
	  */
	 void step (ArrayList<Body> bodies){
		 this.bodies = bodies;
		 dB.setBodies(bodies);
		 dB.repaint();
	 }
	 /* 
	  * Implementation of mouse listeners for click and drag functionality and use of mouse wheel for zooming.
	  */
	 private class MouseListener extends MouseAdapter {
	    	int xStart;
	        int yStart;
	        JPanel panel;
	        
	        private MouseListener(JPanel panel) {
	        	this.panel = panel;
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	xStart = e.getX();
	        	yStart = e.getY();
	        }
	        
	        @Override
	        public void mouseDragged(MouseEvent e) {
	        	int xEnd = e.getX();
	            int yEnd = e.getY();
	            JViewport viewPort = (JViewport) e.getSource();
	            Point vpp = viewPort.getViewPosition();
	            vpp.translate((xStart - xEnd) / 6, (yStart - yEnd) / 6);
	            panel.scrollRectToVisible(new Rectangle(vpp, viewPort.getSize()));
	        }
	 }
}
