package Engine;

public class BoundingBox {

	//-----Members-----
	float width;
	float height;
	
	float xPosition;
	float yPosition;
	
	
	//-----Constructors-----
	/**
	 * This creates an empty bounding box.
	 */
	BoundingBox() {
		width = 0;
		height = 0;
		xPosition = 0;
		yPosition = 0;
	}
	/**
	 * This creates a Bounding Box. The x, y, width, height correspond to the upper left corner of the box. 
	 * 
	 * @param xPosition
	 * @param yPosition
	 * @param width
	 * @param height
	 */
	BoundingBox(float xPosition, float yPosition, float width, float height) {
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	//-----Methods-----
	/**
	 * 
	 * This is a convenience method to update both the x and y position of the bounding box.
	 * 
	 * @param xPosition
	 * @param yPosition
	 */
	public void updatePosition(float xPosition, float yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
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
		if (box1.getXPosition() + box1.getWidth() < box2.getXPosition() ) {
			return true;
		}
		//check box1 left edge with box2 right edge
		else if(box1.getXPosition() < box2.getXPosition() + box2.getWidth()) {
			return true;
		}
		//check box1 top edge with box2 bottom edge
		else if(box1.getYPosition() > box2.getYPosition() + box2.getHeight()) {
			return true;
		}
		//check box1 bottom edge with box2 top edge
		else if(box1.getYPosition() + box1.getHeight() > box2.getYPosition()) {
			return true;
		}
		return false;
	}
	//-----Getters/Setters-----

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @return the xPosition
	 */
	public float getXPosition() {
		return xPosition;
	}

	/**
	 * @param xPosition the xPosition to set
	 */
	public void setXPosition(float xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public float getYPosition() {
		return yPosition;
	}

	/**
	 * @param yPosition the yPosition to set
	 */
	public void setYPosition(float yPosition) {
		this.yPosition = yPosition;
	}
	
}
