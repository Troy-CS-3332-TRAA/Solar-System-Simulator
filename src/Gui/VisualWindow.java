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
		 this.getContentPane().add(new MouseScroll().createScroll());
		 dB = new DrawBodies(bodies);
		 this.add(dB);
		 this.getContentPane().add(dB);
		 this.setPreferredSize(new Dimension(500,500));
		// this.setVisible(true);
	 }
	 /*
	  * Default constructor lacking bodies information.
	  */
	 VisualWindow(String title){
		 super(title);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 this.getContentPane().add(new MouseScroll().createScroll());
		 this.setPreferredSize(new Dimension(500,500));
		 this.setVisible(true);
	 }
	 /*
	  * Can be called to create a new DrawBodies instance and then add that panel to the frame. 
	  */
	 void initVisualWindow(ArrayList<Body> bodies){
		 dB = new DrawBodies(bodies);
		 this.add(dB);
		 this.getContentPane().add(dB);
	 }
	 /*
	  * Used by controller to interatively update information and redraw the system. 
	  */
	 void step (ArrayList<Body> bodies){
		 this.bodies = bodies;
		 dB.setBodies(bodies);
		 dB.repaint();
	 }
	 /* 
	  * Implementation of mouse listeners for click and drag functionality and use of mouse wheel for zooming.
	  */
	 public class MouseScroll {
			 class MouseScrollListener extends MouseAdapter{
				private final Point pp = new Point();
				@Override
				public void mouseDragged(MouseEvent e){
					JViewport viewPort = (JViewport)e.getSource();
					JComponent ourLabel = (JComponent)viewPort.getView();
					Point cp = e.getPoint();
					Point vp = viewPort.getViewPosition();
					vp.translate(pp.x-cp.x, pp.y-cp.y);
					ourLabel.scrollRectToVisible(new Rectangle(vp, viewPort.getSize()));
					pp.setLocation(cp);
				}
				@Override
				public void mousePressed(MouseEvent e){
					pp.setLocation(e.getPoint());
				}
			}
			public JComponent createScroll(){ 
				JScrollPane scroll = new JScrollPane(dB);
				JViewport viewPort = scroll.getViewport();
				MouseAdapter mouseAdapt = new MouseScrollListener();
				viewPort.addMouseMotionListener(mouseAdapt);
				viewPort.addMouseListener(mouseAdapt);
				viewPort.addMouseWheelListener(new MouseAdapter() {
	                @Override
	                public void mouseWheelMoved(MouseWheelEvent e1) {
	                    double delta = 0.05f * e1.getPreciseWheelRotation();
	                    scale += delta;
	                    revalidate();
	                    repaint();
	                }

	            });
				return scroll;
			}
			
		}
}
