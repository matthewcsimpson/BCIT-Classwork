import java.util.HashMap;

/**
 * COMP1451 Lab 03b - refactor the game, add a back function via a stack
 * @author Matthew Simpson
 * @date Winter 2019
 */

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * 
 */
public class Room 
{
    public String description;
    
    HashMap<String, Room> roomExits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description, a string, the room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        roomExits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room. 
     * @param direction, a string, the direction to proceed in.
     * @param room, a Room object, the room that direction will lead to
     * 
     */
    public void defineExits(String direction, Room room) 
    {
        roomExits.put(direction, room);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
    	
        return "You are " + description;
    }
    
    /**
     * return a list of viable exits for a given room. 
     * @return allExits, a string, the list of exits from the room the method is called on.
     */
    public String listExits() {
    	String allExits = "You can go: ";
    	for(String eachExit : roomExits.keySet()) {
    		allExits += eachExit + " ";
    	}
    	return allExits;
    	
    }
    
    /**
     * return a room object based on direction to proceed. 
     * 
     * @param direction, a string, the direction to proceed. 
     * @return the room that lies in the specified direction. 
     */
    public Room goExit(String direction) {
    	return roomExits.get(direction);
    }

}
