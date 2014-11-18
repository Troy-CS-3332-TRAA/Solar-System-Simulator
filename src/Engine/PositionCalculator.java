package Engine;

import java.util.ArrayList;


/**
 * @author CharlesWomble
 *This class is used to find the next step in the program,
 *ie. where the planets will be in the next interval
 */
public class PositionCalculator 
{
	/**
	 * @author CharlesWomble
	 * This method moves the Body to it's new position, it moves to the coordinates in its
	 * velocity vector minus the force of gravity on the object, this should cause the Body
	 * to orbit.Need to implement some action in case of collision
	 * @param child the Body to move
	 * @param mother the Body that the movement is relative to
	 * @param bodies the ArrayList of bodies, needed to check for collision
	 * @return true if no collision detected, false if collision detected
	 */
	public static boolean setNewPosition(Body child, Body mother, ArrayList<Body> bodies )
	{
		child.setPositionX(child.velocity.getVelocityX() - getGravForce(child, mother));
		child.setPositionY(child.velocity.getVelocityY() - getGravForce(child, mother));
		if (CollisionDetector.detectCollision(child, bodies))
			return false;
		child.velocity.updateVelocity(child, mother);
		
		return true;
	}
	
	/**
	 * @author CharlesWomble
	 * This function finds the gravitational attraction between two bodies
	 * used to help with position calculator
	 * works by this formula, Force = GRAVCONSTANT * ((mass1 * mass2)/distance squared)
	 * @param tempbody1
	 * @param tempbody2
	 * @return gravForce, the strength of gravity between two Bodies
	 */
	public static double getGravForce (Body tempbody1, Body tempbody2)
	{
		double gravForce;
		gravForce = Body.GRAVCONSTANT * ((tempbody1.getMass() * tempbody2.getMass())/
				Math.pow(Body.getDistance(tempbody1, tempbody2), 2.0));
		return gravForce;
	}
	
	
}
