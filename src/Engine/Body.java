package Engine;

public class Body {

	//-----Members-----
	float xPosition;
	float yPosition;
	float zPosition;
	
	float mass;
	float gravityInfluenceRangeOffset; //This number is the pad that surrounds the body that shows the range of gravity influence
	
	float radius;
	
	Velocity velocity;
	
	BoundingBox box;
	
	//-----Constructors-----
	/**
	 * Creates an empty body object. *Warning* Nothing is initialized.
	 */
	Body() {
		
	}
	/**
	 * 
	 * This constructs a celestial body containing the mass, position, velocity of the object.
	 * 
	 * @param xPosition The x position from the center of the object
	 * @param yPosition The y position from the center of the object
	 * @param zPosition The z position from the center of the object
	 * @param mass The mass of the object
	 * @param velocity The vector containing speed and direction
	 */
	Body(float xPosition, float yPosition, float zPosition, float radius, float mass, Velocity velocity) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.zPosition = zPosition;
		this.mass = mass;
		this.velocity = velocity;
		box = new BoundingBox(xPosition - radius - gravityInfluenceRangeOffset, yPosition  + radius + gravityInfluenceRangeOffset, radius + gravityInfluenceRangeOffset, radius + gravityInfluenceRangeOffset);
	}
	//-----Methods-----
	/**
	 * 
	 * This is a convenience method to update both the x and y position of the bounding box.
	 * 
	 * @param xPosition
	 * @param yPosition
	 */
	public void updatePosition(float xDelta, float yDelta, float zDelta) {
		this.xPosition = xPosition + xDelta;
		this.yPosition = yPosition + yDelta;
		this.zPosition = zPosition + zDelta;
		box.updatePosition(box.getXPosition() + xDelta, box.getYPosition() + yDelta);
	}
	
}
