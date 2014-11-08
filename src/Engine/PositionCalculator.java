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
	
	public double getGravityPull ()
	{
		//TODO implement this code
		return 1.0;
	}
	
	
}
