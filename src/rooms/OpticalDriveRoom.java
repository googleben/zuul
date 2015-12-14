package rooms;

import engine.*;

public class OpticalDriveRoom extends Room {

    static String desc = "";
    
	public OpticalDriveRoom(String description) {
		super(desc);
		this.items.put("laser",Game.itemList.get("laser"));
	}
	
	public void makeExits() {
	    this.rooms.put("south", Game.roomList.get("satahub"));
	    this.rooms.put("east", Game.roomList.get("fan"));
	}
	
}
