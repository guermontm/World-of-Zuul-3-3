import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Room class. Corresponds to the room in which the player is.
 * Changes each time the player room according to his direction.
 * All the rooms are linked together.
 * @author (Morgane GUERMONT, Adèle RICHARD, Nolan LACROIX, Pauline ANDREO, Clément RISSO)
 * @version (0.1)
 */
public class Room
{
    // instance variables for the Room class.
    // Name of the room
    protected String roomName;
    // Description of the room that is displayed when the player enters
    protected String roomDescription;
    // List of items in the room
    protected ArrayList<Item> listRoomItem;
    
    // Hasmap containing all the rooms and their direction. Used to position the player.
    protected HashMap<String,Room> mapRoom;
    
    /**
     * Constructor for objects of class Room
     */
    public Room()
    {
        // initialise instance variables
        roomName = "Default Room";
        roomDescription = "You are not supposed to see this. If you see this, something went wrong at some point. Please report.";
        listRoomItem = new ArrayList<Item>();
        mapRoom = new HashMap<String,Room>();
        
    }

    /**
     * Constructor for objects of class Room
     */
    public Room(String name, String description)
    {
        roomName = name;
        roomDescription = description;
        listRoomItem = new ArrayList<Item>();
        mapRoom = new HashMap<String,Room>();
    }

    /**
    * Getter for the name of the Room.
    * @return roomName name of the room.
    */
    public String getName()
    {
        return roomName;
    }

    /**
    * Getter for the description of the room.
    * @return roomDescription description of the room.
    */
    public String getDescription()
    {
        return roomDescription;
    }

    /**
    * Setter for the four exits of the room.
    * @param north room in the north of this one.
    * @param south room in the south of this one.
    * @param east room in the east of this one.
    * @param west room in the west  of this one.
    */
    public void setExits(Room north, Room east, Room south, Room west)
    {
        mapRoom.put("north",north);
        mapRoom.put("east",east);
        mapRoom.put("south",south);
        mapRoom.put("west",west);
    }

    /**
    * Accessor for the different exits of a room.
    * @return a hashmap containing the exits.
    */
    public HashMap<String,Room> getExits()
    {
        return(mapRoom);
    }
    
    public void addItem (Item newItem){
        
        listRoomItem.add(newItem);
    }

    /**
    * Getter for the items in the room.
    *  @return array list of items.
    */
    public ArrayList<Item> getItems()
    {
        return listRoomItem;
    }
    
    /**
    *   Printer for all the items in the room.
    *   Displays the items in the list.
    */
    public void printItems()
    {
        int i;
        for (i=0; i<listRoomItem.size(); i++)
        {
            System.out.println(""+i + "\t:\t"+listRoomItem.get(i).itemName);
        }
    }

}