package rooms;

import engine.*;

public class ChipsetRoom extends Room {
    
    static String desc = "You can see the information travelling, it seems as if this is the hub meaning you’re at the chipset, has to be an intel c600. Such intense circuitry. ";
    
	public ChipsetRoom() {
		super(desc);
	}
	
	public void makeExits() {
	    rooms.put("north", Game.roomList.get("satahub"));
	    rooms.put("south", Game.roomList.get("cpu"));
	    rooms.put("east", Game.roomList.get("pciehub"));
	}
	
}
