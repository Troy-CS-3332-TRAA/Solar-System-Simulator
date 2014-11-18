package Engine;

/**
 * @author CharlesWomble
 *This class is used to hold data about the velocity of the Bodies and 
 *useful formulas
 */
public class Velocity 
{

	//***members***//
	double velocityX;
	double velocityY;
	double velocityZ;
	double speed;			//not used yet
	double orbitalVelocity; //this will be calculated //not used yet
	
	/**
	 * @author CharlesWomble
	 * just a default constructor that doesn't do anything
	 */
	Velocity()
	{
		velocityX = 0.0;
		velocityY = 0.0;
		velocityZ = 0.0;
		speed = 0.0;
		orbitalVelocity = 0.0;
	}
	
	/**
	 * @author CharlesWomble
	 * This is a constructor for the 2D simulations, as such it only accepts
	 * params for x and y velocity vectors
	 * @param posX x velocity position
	 * @param posY y velocity position
	 */
	Velocity(double posX, double posY)
	{
		velocityX = posX;
		velocityY = posY;
		velocityZ = 0.0;
		speed = 0.0;
		orbitalVelocity = 0.0;
	}
	
	/**
	 * @author CharlesWomble
	 * this is not used yet but will be in the future.
	 * @param orbitalVelocity
	 */
	Velocity(double orbitalVelocity)
	{
		this.orbitalVelocity = orbitalVelocity;
	}
	
	/**
	 * This constructor is primarily used during a loadState()
	 * @author Dexter Parks
	 * Nov 17, 2014
	 * @param vX
	 * @param vY
	 * @param vZ
	 */
	public Velocity(double vX, double vY, double vZ) {
		velocityX = vX;
		velocityY = vY;
		velocityZ = vZ;
	}

	/**
	 * @author CharlesWomble
	 * @return the velocityX
	 */
	public double getVelocityX() {
		return velocityX;
	}

	/**
	 * @author CharlesWomble
	 * @param velocityX the velocityX to set
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * @author CharlesWomble
	 * @return the velocityY
	 */
	public double getVelocityY() {
		return velocityY;
	}

	/**
	 * @author CharlesWomble
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * @author CharlesWomble
	 * @return the velocityZ
	 */
	public double getVelocityZ() {
		return velocityZ;
	}

	/**
	 * @author CharlesWomble
	 * @param velocityZ the velocityZ to set
	 */
	public void setVelocityZ(double velocityZ) {
		this.velocityZ = velocityZ;
	}

	/**
	 * @author CharlesWomble
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @author CharlesWomble
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @author CharlesWomble
	 * @return the orbitalVelocity
	 */
	public double getOrbitalVelocity() {
		return orbitalVelocity;
	}

	/**
	 * @author CharlesWomble
	 * @param orbitalVelocity the orbitalVelocity to set
	 */
	public void setOrbitalVelocity(double orbitalVelocity) {
		this.orbitalVelocity = orbitalVelocity;
	}

	/**
	 * @author CharlesWomble
	 * this method updates the velocity vector to it's new coordinates after a timestep
	 * it assumes (as does kepler's laws) that the velocity of an object in orbit to be constant.
	 * pseudo code for this is here
	 * => cx^2+cy^2==ac^2 && (cx-ab)^2+cy^2==bc^2
	 * => cx^2-(cx-ab)^2==ac^2-bc^2
	 * => 2*cx*ab==ac^2-bc^2+ab^2
	 * => cx = (ac^2-bc^2+ab^2)/(2*ab)
	 * => cy = +/- sqrt(ac^2-cx^2)   iff ac^2-cx^2 > 0
	 * => cy = 0   iff ac^2-cx^2 = 0
	 * => no solution    else
	 * @param child the Body that we want to update the velocity of
	 * @param mother the mother body of the planet
	 */
	public void updateVelocity(Body child, Body mother)
	{
		child.velocity.setVelocityX((Math.pow(Velocity.distanceFromVelocity(mother, child.velocity), 2.0)
				- Math.pow(Velocity.distanceFromVelocity(child, child.velocity), 2.0) 
				+ Math.pow(child.getDistanceFromStar(), 2.0)) / (2 * child.getDistanceFromStar()) );
		child.velocity.setVelocityY((Math.sqrt(Math.pow(Velocity.distanceFromVelocity(mother, child.velocity), 2.0))
				- Math.pow(child.velocity.getVelocityX(), 2.0))); 
		// this goes for the positive value, but it could also be a negative value, how to figure out which?
	}
	
	/**
	 * @author CharlesWomble
	 * This method simply computes the distance between a Body and the velocity Vector of a Body
	 * @param tempBod the body to compute the distance from (not necessrily computing it's own
	 * vector coordinates since I need to be able to compute the distance from the mother body)
	 * @param tempVel the velocity vector to find the distance to
	 * @return distance the distance between the two points.
	 */
	public static double distanceFromVelocity(Body tempBod, Velocity tempVel)
	{
		double distance;
		distance = Math.sqrt( Math.pow((tempBod.getPositionY() - tempBod.getPositionX()), 2.0) +
				     Math.pow((tempVel.getVelocityY() - tempVel.getVelocityX()), 2.0) );
		return distance;
	}
}