package Engine;

import java.lang.Math; //for getDistance, pow/sqrt functions


/**
 * @author CharlesWomble
 * this class represents the objects
 * in the solar system.
 * 
 * NOTE: distances, including radius of Bodies,
 * are represented by 10 to the power of 6 in km, 
 * whereas mass is measured by 10 to the power of 21 in kg.
 * for example the input 778.6 for distance would be
 * 778,600,000 km. for 5973.6 the mass would be
 * 5,973,600,000,000,000,000,000,000 kg.
 */
public class Body 
{
	//members//
	String name;
	static double GRAVCONSTANT = .000000000066719199;   //??? should this be moved to another class???
	//GRAVCONSTANT is actually 6.67191(99)*10 ^-11 m^3 * kg^-1 * s^-2
	double positionX;
	double positionY;
	double positionZ;
	double radius;                                       // double * 10^6
	double mass;                                         // double * 10^21
	double gravityradius;                                // double * 10^6
	double distancefromstar; //calculated in constructor // double * 10^6
	boolean isstar; //used for above^
	BoundingBox box; // <-- fix this 
	Velocity velocity;
	
	/**
	 * @author CharlesWomble
	 * default constructor
	 */
	Body ()
	{
		name             = "Default name";
		positionX        = 0.0;
		positionY        = 0.0;
		positionZ        = 0.0;
		radius           = 0.0; // measured in 10 ^ 6  km
		mass             = 0.0; // measured in 10 ^ 21 kg
		gravityradius    = 0.0; // measured in 10 ^ 6  km
		distancefromstar = 0.0; // measured in 10 ^ 6  km
		isstar           = true;
		Engine.addBody(this);
	}
	
	/**
	 * @author CharlesWomble
	 * Constructs a star in center of coordinates
	 * @param nam
	 * @param rad
	 * @param mas
	 */
	Body (String nam,double rad, double mas)
	{
		name             = nam;
		positionX        = 0.0;
		positionY        = 0.0;
		positionZ        = 0.0;
		radius           = rad;
		mass             = mas;
		distancefromstar = 0.0;
		isstar           = true;
		gravityradius    = this.getGravity();
		Engine.addBody(this);	
	}
	
	/**
	 * @author CharlesWomble
	 * Constructs a Body with specified variables
	 * @param nam
	 * @param posx
	 * @param posy
	 * @param posz
	 * @param rad
	 * @param mas
	 */
	Body (String nam, double posx, double posy, double posz, double rad, double mas)
	{
		name             = nam;
		positionX        = posx;
		positionY        = posy;
		positionZ        = posz;
		radius           = rad;
		mass             = mas;
		distancefromstar = Body.getDistance(this, Engine.BodyList.get(0));
		isstar           = false;
		gravityradius    = this.getGravity();
		Engine.addBody(this);	
	}
	
	//**************Methods**************//
	/**
	 * @author CharlesWomble
	 * This method returns the Mass of the Body
	 * @return
	 */
	public double getMass ()
	{
		return mass;
	}
	
	/**
	 * @author CharlesWomble
	 * This method returns the specified coordinate of the Body
	 * @param x
	 * @return
	 */
	public double getPosition(int x)
	{
		double[] positionArray = new double[] {positionX, positionY, positionZ};
		return positionArray[x];
	}
	
	/**
	 * @author CharlesWomble
	 * returns the gravity strength of the Body
	 * @return
	 */
	public double getGravity()
	{
		double gravity=0.0;
		//implement math here
		return gravity;
	}
	
	/**
	 * @author CharlesWomble
	 * Sets the mass of the Body
	 * @param mas
	 */
	public void setMass(double mas)
	{
		mass=mas;
	}
	
	/**
	 * @author CharlesWomble
	 * sets the positions of the Body
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setPosition (double x,double y, double z)
	{
		positionX = x;
		positionY = y;
		positionZ = z;
	}
	
	/**
	 * @author CharlesWomble
	 * sets radius of Body
	 * @param rad
	 */
	public void setRadius(double rad)
	{
		radius = rad;
	}
	
	/**
	 * @author CharlesWomble
	 * gets the distance between two bodies
	 * @param tempbody1
	 * @param tempbody2
	 * @return
	 * ??? should this go to another class???
	 * currently this is static as it is called in the constructor
	 * of the Body class (to get distancefromstar)
	 */
	public static double getDistance(Body tempbody1, Body tempbody2)
	{
		double distance;
		distance = Math.sqrt( Math.pow((tempbody1.getPosition(2) - tempbody1.getPosition(1)), 2.0) +
				     Math.pow((tempbody2.getPosition(2) - tempbody2.getPosition(1)), 2.0) );
		return distance;
	}
	
	/**
	 * @author CharlesWomble
	 * This function finds the gravitational attraction between two bodies
	 * used to help with position calculator
	 * works by this formula, Force = GRAVCONSTANT * ((mass1 * mass2)/distance squared)
	 * @param tempbody1
	 * @param tempbody2
	 * @return
	 * ??? should this go to another class???
	 */
	public double getGravForce (Body tempbody1, Body tempbody2)
	{
		double gravforce;
		gravforce = GRAVCONSTANT * ((tempbody1.getMass() * tempbody2.getMass())/
				Math.pow(Body.getDistance(tempbody1, tempbody2), 2.0));
		return gravforce;
	}
	//End of class Body
}

