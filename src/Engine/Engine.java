package Engine;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList; //for making the BodyList
import java.util.List;

public class Engine {
	
	//-----Global Members-----
	ArrayList<Body> bodies = new ArrayList<Body>();
	
	//-----Main Methods-----
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
	
	/**
	 * Clears any previoulsy used variables and initializes them for a new simulation.
	 * @author Dexter Parks
	 * Nov 6, 2014
	 * @return True if success, fail if there was an error.
	 */
	public boolean newSimulation() {
		//TODO Implement newSimulation()
		return true;
	}
	
	/**
	 * Clears any previously used varibales and initializes them from a given file input.
	 * @author Dexter Parks
	 * Nov 6, 2014
	 * @return True if success, fail if there was an error.
	 */
	public boolean loadSimulation(File file) {
		boolean success = false;
		bodies = new ArrayList<Body>();
		success = loadState(file, bodies);
		return success;
	}
	
	/**
	 * Saves the current state as a CSV file.
	 * @author Dexter
	 * Nov 6, 2014
	 * @param file The file corresponding to the location of where to save the file.
	 * @return True if success, fail if there was an error.
	 */
	public boolean saveSimulation(File file) {
		boolean success = false;
		success = saveState(file, bodies);
		return success;
	}
	
	//-----Utility Methods-----
	
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
	
	/**
	 * @author CharlesWomble
	 * This method saves the state of the program 
	 * to a CSV file.
	 * @param fileName user inputs name of file
	 * @param Bodies  accepts BodyList as parameter
	 * @return boolean, true if successful false if not
	 */
	public boolean saveState(File file, ArrayList <Body> Bodies)
	{
		try 
		{
			FileWriter writer = new FileWriter (file);
			
			for (int x = 0; x < Bodies.size(); x++)
			{
			writer.append(Bodies.get(x).getName());
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getPosition(1)));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getPosition(2)));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getPosition(3)));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getRadius()));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getMass()));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getGravity()));
			writer.append(',');
			writer.append(Integer.toString(Bodies.get(x).getStar()));
			writer.append(',');
			writer.append(Double.toString(Bodies.get(x).getVelocity()));
			writer.append('\n');
			writer.flush();
			}
			writer.close();
			return true;
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	/**
	 * @author Dexter Parks
	 * @param file the input file to read
	 * @param bodies the arraylist of the bodies, output
	 * @return Boolean, true if it read the bodies from the file into the ArrayList
	 * Reads a file and produces an ArrayList of Body objects.
	 */
	public boolean loadState(File file, ArrayList<Body> bodies) 
	{
		List<String> list;
		try {
			//Reads a list of files where each line in the file is an array element
			list = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		String name;
		double positionX;
		double positionY;
		double positionZ;
		double radius;                                       // double * 10^6
		double mass;                                         // double * 10^21
		double gravityRadius;                                // double * 10^6
		boolean isStar;
		Velocity velocity;
		for(String row : list) {
			//Splits the line by use the comma as a delimiter, then parses them to the correct datatype
			String[] rowSplit = row.split(",");
			name = rowSplit[0];
			positionX = Double.parseDouble(rowSplit[1]);
			positionY = Double.parseDouble(rowSplit[2]);
			positionZ = Double.parseDouble(rowSplit[3]);
			radius = Double.parseDouble(rowSplit[4]);
			mass = Double.parseDouble(rowSplit[5]);
			gravityRadius = Double.parseDouble(rowSplit[6]);
			isStar = Boolean.parseBoolean(rowSplit[7]);
			velocity = new Velocity(Double.parseDouble(rowSplit[8]));
			//Constructs abody object and adds it to the ArrayList
			bodies.add(new Body(name, positionX, positionY, positionZ, radius, mass, velocity));
		}
		return !bodies.isEmpty();
	}
}
