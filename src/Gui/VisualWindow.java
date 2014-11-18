package Gui;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	 VisualWindow(String title){
		 super(title);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 this.getContentPane().add(new MouseScroll().createScroll());
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
