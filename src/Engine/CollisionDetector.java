package Engine;

import java.util.ArrayList; //to be able to accept BodyList as a parameter

/**
 * @author CharlesWomble
 *This class is used to determine if a collision has occurred,
 *the Engine class will call this after the position calculator is called,
 *the code is incomplete, I need to confer with @DexterParks about his BoundingBox code
 */
public class CollisionDetector 
{
	
	/**
	 * @author CharlesWomble
	 * @param tempbody1
	 * @param tempBodyList
	 * @return
	 * This method returns true if a collision has occurred
	 * it is static as we will not be instantiating and object
	 * of this type.
	 */
	public static boolean detectCollision(Body tempbody1, ArrayList<Body> tempBodyList)
	{
		if (!tempBodyList.isEmpty())
		{
			for (int x = 0;x <= (tempBodyList.size()-1);x++)
			{
				if (tempbody1.box.getXPosition() == tempBodyList.get(x).box.getXPosition() & tempbody1.box.getYPosition() == tempBodyList.get(x).box.getYPosition())
				{
				
					return true;
				}
			}
		}
		return false;
	}

}
