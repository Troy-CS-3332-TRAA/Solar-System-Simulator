package Engine;

public class BoundingBox {

	//-----Members-----
	double width;
	double height;
	
	double positionX;
	double positionY;
	
	
	//-----Constructors-----
	/**
	 * This creates an empty bounding box.
	 */
	BoundingBox() {
		width = 0;
		height = 0;
		positionX = 0;
		positionY = 0;
	}
	/**
	 * This creates a Bounding Box. The x, y, width, height correspond to the upper left corner of the box. 
	 * 
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @param height
	 */
	BoundingBox(double positionX, double positionY, double width, double height) {
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	//-----Methods-----
	/**
	 * 
	 * This is a convenience method to update both the x and y position of the bounding box.
	 * 
	 * @param positionX
	 * @param positionY
	 */
	public void updatePosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	//-----Static Methods-----
	/**
	 * 
	 * This method tells if two boxes are intersecting each other.
	 * 
	 * @param box1 The first box to check for intersections
	 * @param box2 The second box to check for intersections
	 * @return Returns false if no boxes intersect, returns true if they do
	 */
	static boolean isIntersecting(BoundingBox box1, BoundingBox box2) {
		//check box1 right edge with box2 left edge
		if (box1.getXPosition() + box1.getWidth() > box2.getXPosition()) {
			//Make sure it is in the same y space
			if(box1.getYPosition() < box2.getYPosition() + box2.getHeight()) {
				return true;
			}
			//check box1 bottom edge with box2 top edge
			else if(box1.getYPosition() + box1.getHeight() > box2.getYPosition()) {
				return true;
			}
		}
		//check box1 left edge with box2 right edge
		else if(box1.getXPosition() < box2.getXPosition() + box2.getWidth()) {
			if(box1.getYPosition() < box2.getYPosition() + box2.getHeight()) {
				return true;
			}
			//check box1 bottom edge with box2 top edge
			else if(box1.getYPosition() + box1.getHeight() > box2.getYPosition()) {
				return true;
			}
		}
		//check box1 top edge with box2 bottom edge
		else if(box1.getYPosition() < box2.getYPosition() + box2.getHeight()) {
			//Make sure it is in the same x space
			if (box1.getXPosition() + box1.getWidth() > box2.getXPosition()) {
				return true;
			}
			else if(box1.getXPosition() < box2.getXPosition() + box2.getWidth()) {
				return true;
			}
		}
		//check box1 bottom edge with box2 top edge
		else if(box1.getYPosition() + box1.getHeight() > box2.getYPosition()) {
			//Make sure it is in the same x space
			if (box1.getXPosition() + box1.getWidth() > box2.getXPosition()) {
				return true;
			}
			else if(box1.getXPosition() < box2.getXPosition() + box2.getWidth()) {
				return true;
			}
		}
		return false;
	}
	//-----Getters/Setters-----

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the positionX
	 */
	public double getXPosition() {
		return positionX;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setXPosition(double positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public double getYPosition() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setYPosition(double positionY) {
		this.positionY = positionY;
	}
	
}