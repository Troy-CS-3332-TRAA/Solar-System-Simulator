package Engine;


/**
 * @author CharlesWomble
 *This class is used to find the next step in the program,
 *ie. where the planets will be in the next interval
 */
public class PositionCalculator 
{

	//-----Members-----//
	Body temp;
	
	
	
	//-----Method-----//
	
	
	public boolean setNewPosition(Body tempbody)
	{
		//members//
		double[]oldposition = new double[]{0.0,0.0,0.0};
		
		oldposition[0] = tempbody.getPositionX();
		oldposition[1] = tempbody.getPositionY();
		oldposition[2] = tempbody.getPositionZ();
		
		//velocity? 
		
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
	public double getGravForce (Body tempbody1, Body tempbody2)
	{
		double gravForce;
		gravForce = Body.GRAVCONSTANT * ((tempbody1.getMass() * tempbody2.getMass())/
				Math.pow(Body.getDistance(tempbody1, tempbody2), 2.0));
		return gravForce;
	}
	
	
}
