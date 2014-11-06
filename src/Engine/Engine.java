package Engine;
import java.util.ArrayList; //for making the BodyList

public class Engine {
	
	//*****Global Members*****
	Body bodies;
	static ArrayList<Body> BodyList = new ArrayList<Body>();
	
	//*****Main Methods*****
	/**
	 * This is method that is called to simulate the next step of the simulation
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public void step() {
		
	}
	
	/**
	 * This method is used to detect a collision among the bodies.
	 * @author Dexter Parks
	 * @version 1.0
	 * @return True if collision occurred
	 */
	boolean detectCollisions() {
		
		//TODO Implement collision detection
		
		return false;
	}
	
	/**
	 * This method is used to calculate the position of the bodies during after one step
	 * @author Charles Womble
	 * @version 1.0
	 * @return
	 */
	boolean calculatePositions() 
	{
		
		//TODO Implement position calculator
		
		return true;
	}
	
	//*****Utility Methods*****
	
	/**
	 * @author CharlesWomble
	 * @param tempBodyList
	 * This method is not needed, as ArrayList contains the method sort which
	 * essentially does the same thing, however I will keep this code 
	 * for now, eventually we can implement the sort method.
	 */
	public static void arrangeList (ArrayList<Body> tempBodyList)
	{
		int numbodies = tempBodyList.size();
		/*
		 * this code checks the newest added Body with every other
		 * Body in BodyList, if it is larger than one
		 * it will place the Body in its index and shift every other 
		 * Body one position to the right.
		 * then it removes the new body from the end of BodyList
		 */
		for (int x = 0; x > numbodies; x++)
		{
				int y = numbodies - 1;
				if (tempBodyList.get(y).getMass() > BodyList.get(x).getMass())
				{
					BodyList.add(x, tempBodyList.get(y));
					BodyList.remove(y+1);
				}
		}
	}
	
	/**
	 * @author CharlesWomble
	 * @param tempbody
	 * This method adds a new Body to the end of the BodyList
	 */
	public static void addBody (Body tempbody)
	{
		//add new body to BodyList
		BodyList.add(tempbody);
		//Re-arrange BodyList
		arrangeList(BodyList);
	}
	
	/**
	 * @author CharlesWomble
	 * @param x
	 * This method removes a Body from the BodyList at the 
	 * specified position x.
	 */
	public void removeBody(int x)
	{
		BodyList.remove(x);
	}
	
	public boolean saveState(String fileName)
	{
		return true;
	}
	
	public boolean loadState(String fileName)
	{
		return true;
	}
}