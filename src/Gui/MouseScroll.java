package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class MouseScroll {
	static class MouseScrollListener extends MouseAdapter{
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
	public JComponent makeUI(){
		JLabel label = new JLabel(new Icon(){
			TexturePaint TEXTURE = makeCheckerTexture();
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y){
				Graphics2D g2 = (Graphics2D)g.create();
				g2.setPaint(TEXTURE);
				g2.fillRect(x, y, c.getWidth(), c.getHeight());
				g2.dispose();
			}
			@Override 
			public int getIconWidth(){
				return 2000;
			}
			@Override
			public int getIconHeight(){
				return 2000;
			}
		});
		label.setBorder(BorderFactory.createLineBorder(Color.RED, 20));
		JScrollPane scroll = new JScrollPane(label);
		JViewport viewPort = scroll.getViewport();
		MouseAdapter mouseAdapt = new MouseScrollListener();
		viewPort.addMouseMotionListener(mouseAdapt);
		viewPort.addMouseListener(mouseAdapt);
		return scroll;
	}
	private static TexturePaint makeCheckerTexture() {
	    int cs = 20;
	    int sz = cs*cs;
	    BufferedImage img = new BufferedImage(sz,sz,BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = img.createGraphics();
	    g2.setPaint(Color.GRAY);
	    for(int i=0; i*cs<sz; i++) { for(int j=0; j*cs<sz; j++) {
	      if((i+j)%2==0) { g2.fillRect(i*cs, j*cs, cs, cs); }
	    }}
	    g2.dispose();
	    return new TexturePaint(img, new Rectangle(0,0,sz,sz));
	  }
}
