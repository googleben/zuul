package rooms;

import engine.*;

public class OpticalDriveRoom extends Room {

    static String desc = "You appear to be inside the optical drive of a computer. \nYou see a fan on the side of the computer, and the SATA hub down the wire.";
    
	public OpticalDriveRoom() {
		super(desc);
		this.items.put("laser",Game.itemList.get("laser"));
	}
	
	public void makeExits() {
	    this.rooms.put("down", Game.roomList.get("satahub"));
	    this.rooms.put("east", Game.roomList.get("fan"));
	}
	
}
