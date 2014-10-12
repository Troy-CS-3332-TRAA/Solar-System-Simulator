package Engine;

public class Engine {
	
	//*****Global Members*****
	Body bodies;
	
	//*****Main Methods*****
	/**
	 * This is method that is called to simulate the next step of the simulation
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public void step() {
		
	}
	
	/**
	 * This method is used to detect a collision among the bodies.
	 * @author Dexter Parks
	 * @version 1.0
	 * @return True if collision occurred
	 */
	boolean detectCollisions() {
		boolean collision = false;
		for(Body b1 : bodies) {
			for(Body b2 : bodies) {
				collision = BoundingBox.isIntersecting(b1.getBox(), b2.getBox());
			}
		}
		
		return collision;
	}
	
	/**
	 * This method is used to calculate the position of the bodies during after one step
	 * @author Charles Womble
	 * @version 1.0
	 * @return
	 */
	boolean calculatePositions() {
		
		//TODO Implement position calculator
		
		return true;
	}
	
	//*****Utility Methods*****
	
	
}
