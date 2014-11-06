package Engine;


/**
 * @author CharlesWomble
 *This class is used to find the next step in the program,
 *ie. where the planets will be in the next interval
 */
public class PositionCalculator 
{

	//*****Members*****//
	Body temp;
	
	
	
	//*****Methods*****//
	
	
	public boolean setNewPosition(Body tempbody)
	{
		//members//
		double[]oldposition = new double[]{0.0,0.0,0.0};
		
		oldposition[0] = tempbody.getPosition(0);
		oldposition[1] = tempbody.getPosition(1);
		oldposition[2] = tempbody.getPosition(2);
		
		//velocity? 
		
		return true;
	}
	
	public double getGravityPull ()
	{
		//TODO implement this code
		return 1.0;
	}
	
	
}
