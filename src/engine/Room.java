package engine;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room {

    public String description;
    public ArrayList<Command> commands;
    public HashMap<String, Room> rooms;
    public HashMap<String, Command> override;
    public boolean isLocked;
    public HashMap<String, Item> items;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description
     *            The room's description.
     */
    public Room(String description) {
        this.description = description;
        this.rooms = new HashMap<String, Room>();
        this.override = new HashMap<String, Command>();
        items = new HashMap<String, Item>();
        this.isLocked = false;
    }

    public Room travel(String dir) {
        return rooms.get(dir);
    }
    
    public Room init(Room r) {
    	return this;
    }

    public boolean hasRoom(String dir) {
        return rooms.containsKey(dir);
    }

    /**
     * Define the exits of this room. Every direction either leads to another
     * room or is null (no exit there).
     * 
     * @param north
     *            The north exit.
     * @param east
     *            The east east.
     * @param south
     *            The south exit.
     * @param west
     *            The west exit.
     */
    public void setExits(String dir, Room room) {
        rooms.put(dir, room);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description + "\n" + getDynamicDescription();
    }

    public String getDynamicDescription() {
        String ans = "Exits: ";
        for (String s : rooms.keySet())
            ans += s + ", ";
        ans = ans.substring(0, ans.length() - 2);
        if (items.size()!=0) {
            ans+="\nYou see ";
            for (Item i : items.values()) ans+="a "+i.name+", ";
            ans = ans.substring(0,ans.length()-2);
        }
        return ans;
    }
    
    public boolean containsItem(String i) {
        return items.containsKey(i);
    }
    public Item removeItem(String i) {
        return items.remove(i);
    }
    public void addItem(String s, Item i) {
        items.put(s,i);
    }
    
    public void makeExits() {}

}
