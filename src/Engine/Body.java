package Engine;

import java.util.Comparator;



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
public class Body implements Comparable<Body>
{
	//-----Members-----//
	String name;
	static double GRAVCONSTANT = .000000000066719199;   //??? should this be moved to another class???
	//GRAVCONSTANT is actually 6.67191(99)*10 ^-11 m^3 * kg^-1 * s^-2
	double positionX;
	double positionY;
	double positionZ;
	double radius;                                       // double * 10^6
	double mass;                                         // double * 10^21
	double gravityRadius;                                // double * 10^6
	double distanceFromStar; //calculated in constructor // double * 10^6
	boolean star; //used for above^
	Velocity velocity;
	BoundingBox box; // <-- fix this 
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
		gravityRadius    = 0.0; // measured in 10 ^ 6  km
		distanceFromStar = 0.0; // measured in 10 ^ 6  km
		star           = true;
	}
	
	/**
	 * @author CharlesWomble
	 * Constructs a star in center of coordinates
	 * @param nam name of Body
	 * @param rad radius of Body
	 * @param mas mass of Body
	 */
	Body (String nam,double rad, double mas)
	{
		name             = nam;
		positionX        = 0.0;
		positionY        = 0.0;
		positionZ        = 0.0;
		radius           = rad;
		mass             = mas;
		distanceFromStar = 0.0;
		star           = true;
		gravityRadius    = this.getGravity();
	}
	
	/**
	 * @author CharlesWomble
	 * Constructs a Body with specified variables
	 * @param nam   name of Body
	 * @param posX  positionX of Body
	 * @param posY  positionY of Body
	 * @param posZ  positionZ of Body
	 * @param rad   radius of Body
	 * @param mas   mass of Body
	 */
	Body (String nam, double posX, double posY, double posZ, double rad, double mass, Velocity velocity2, Body star)
	{
		name             = nam;
		positionX        = posX;
		positionY        = posY;
		positionZ        = posZ;
		radius           = rad;
		this.mass        = mass;
		distanceFromStar = Body.getDistance(this, star);
		this.star      	     = false;
		gravityRadius    = this.getGravity();
	}
	
	//-----Methods-----//
	double getGravity() {
		//TODO Implement getGravity()
		return 0.0;
	}
	
	@Override
	public int compareTo(Body b) {
		return new Double(mass).compareTo(b.getMass());
	}
	
	//-----Getters/Setters-----//
	/**
	 * @author Dexter Parks
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author Dexter Parks
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author Dexter Parks
	 * @return the positionX
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 * @author Dexter Parks
	 * @param positionX the positionX to set
	 */
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 * @author Dexter Parks
	 * @return the positionY
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 * @author Dexter Parks
	 * @param positionY the positionY to set
	 */
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 * @author Dexter Parks
	 * @return the positionZ
	 */
	public double getPositionZ() {
		return positionZ;
	}

	/**
	 * @author Dexter Parks
	 * @param positionZ the positionZ to set
	 */
	public void setPositionZ(double positionZ) {
		this.positionZ = positionZ;
	}

	/**
	 * @author Dexter Parks
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @author Dexter Parks
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @author Dexter Parks
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @author Dexter Parks
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * @author Dexter
	 * @return the gravityRadius
	 */
	public double getGravityRadius() {
		return gravityRadius;
	}

	/**
	 * @author Dexter Parks
	 * @param gravityRadius the gravityRadius to set
	 */
	public void setGravityRadius(double gravityRadius) {
		this.gravityRadius = gravityRadius;
	}

	/**
	 * @author Dexter Parks
	 * @return the distanceFromStar
	 */
	public double getDistanceFromStar() {
		return distanceFromStar;
	}

	/**
	 * @author Dexter Parks
	 * @param distanceFromStar the distanceFromStar to set
	 */
	public void setDistanceFromStar(double distanceFromStar) {
		this.distanceFromStar = distanceFromStar;
	}

	/**
	 * @author Dexter Parks
	 * @return the star
	 */
	public boolean isStar() {
		return star;
	}

	/**
	 * @author Dexter Parks
	 * @param isStar the isStar to set
	 */
	public void setStar(boolean isStar) {
		this.star = isStar;
	}

	/**
	 * @author Dexter Parks
	 * @return the box
	 */
	public BoundingBox getBox() {
		return box;
	}

	/**
	 * @author Dexter Parks
	 * @param box the box to set
	 */
	public void setBox(BoundingBox box) {
		this.box = box;
	}
	
	/**
	 * @author Dexter Parks
	 * @return the velocity
	 */
	public Velocity getVelocity() {
		return velocity;
	}

	/**
	 * @author Dexter Parks
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	/**
	 * @author CharlesWomble
	 * gets the distance between two bodies
	 * @param tempbody1 first body in distance formula
	 * @param tempbody2 second body in distance formula
	 * @return double that is distance between Bodies
	 * ??? should this go to another class???
	 * currently this is static as it is called in the constructor
	 * of the Body class (to get distanceFromStar)
	 */
	public static double getDistance(Body tempbody1, Body tempbody2)
	{
		double distance;
		distance = Math.sqrt( Math.pow((tempbody1.getPositionY() - tempbody1.getPositionX()), 2.0) +
				     Math.pow((tempbody2.getPositionY() - tempbody2.getPositionX()), 2.0) );
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
