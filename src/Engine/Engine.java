package Engine;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList; //for making the BodyList
import java.util.Collections;
import java.util.List;

public class Engine {
	
	//-----Global Members-----//
	private ArrayList<Body> bodies = new ArrayList<Body>();
	private Boolean collision;
	
	//-----Constructors-----//
	public Engine() {
		
	}
	
	//-----Main Methods-----//
	/**
	 * This is method that is called to simulate the next step of the simulation
	 * @author Dexter Parks
	 * @version 1.0
	 * @return 
	 */
	public ArrayList<Body> step() {
		calculatePositions();
		//detectCollisions();
		return bodies;
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
	void calculatePositions() 
	{
		for(Body body : bodies) {
			if(body.isStar()) {
			} else {
				collision = PositionCalculator.setNewPosition(body, bodies.get(0), bodies);
			}
		}
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
	 * Clears any previously used variables and initializes them from a given file input.
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
	
	//-----Utility Methods-----//
	
	/**
	 * @author CharlesWomble
	 * @param tempbody
	 * This method adds a new Body to the end of the BodyList
	 */
	public void addBody (Body tempbody)
	{
		//add new body to BodyList
		bodies.add(tempbody);
		Collections.sort(bodies);
	}
	
	/**
	 * @author CharlesWomble
	 * @param x
	 * This method removes a Body from the BodyList at the 
	 * specified position x.
	 */
	public void removeBody(int x)
	{
		bodies.remove(x);
	}
	
	/**
	 * @author CharlesWomble
	 * This method saves the state of the program 
	 * to a CSV file.
	 * @param fileName user inputs name of file
	 * @param Bodies  accepts BodyList as parameter
	 * @return boolean, true if successful false if not
	 */
	public boolean saveState(File file, ArrayList <Body> bodies)
	{
		try 
		{
			FileWriter writer = new FileWriter (file);
			
			for (int x = 0; x < bodies.size(); x++)
			{
			writer.append(bodies.get(x).getName());
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getPositionX()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getPositionY()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getPositionZ()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getRadius()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getMass()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getDistanceFromStar()));
			writer.append(',');
			writer.append(Boolean.toString(bodies.get(x).isStar()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).getGravity(bodies.get(x))));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).velocity.getVelocityX()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).velocity.getVelocityY()));
			writer.append(',');
			writer.append(Double.toString(bodies.get(x).velocity.getVelocityZ()));
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
		}//name x y z getRadius Mass DistanceFromStar isStar getGravity VX VY VZ
		String name;
		double positionX;
		double positionY;
		double positionZ;
		double radius;                                       // double * 10^6
		double mass;                                         // double * 10^21
		double distanceFromStar;                                // double * 10^6
		boolean isStar;
		double gravity;
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
			distanceFromStar = Double.parseDouble(rowSplit[6]);
			isStar = Boolean.parseBoolean(rowSplit[7]);
			gravity = Double.parseDouble(rowSplit[8]);
			velocity = new Velocity(Double.parseDouble(rowSplit[9]), Double.parseDouble(rowSplit[10]), Double.parseDouble(rowSplit[11]));
			//Constructs a body object and adds it to the ArrayList
			if(bodies.size() == 0) {
				bodies.add(new Body(name, radius, mass));
			} else {
				bodies.add(new Body(name, positionX, positionY, positionZ, radius, mass, distanceFromStar, isStar, gravity, velocity));
			}
			Collections.sort(bodies);
		}
		return !bodies.isEmpty();
	}

	public void loadDefaultSimulation() {
		// TODO Create Default Simulation
		
	}
	
	//-----Getters/Setters-----//

	/**
	 * @return the bodies
	 */
	public ArrayList<Body> getBodies() {
		return bodies;
	}

	/**
	 * @return the collision
	 */
	public Boolean getCollision() {
		return collision;
	}

	/**
	 * @param collision the collision to set
	 */
	public void setCollision(Boolean collision) {
		this.collision = collision;
	}
}
