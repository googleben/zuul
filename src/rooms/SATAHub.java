package rooms;

import engine.*;

public class SATAHub extends Room {

    static String desc = "You are at the SATA hub of the computer. \nWires are all over the place - this is a mess!";
    
	public SATAHub() {
		super(desc);
	}
	
	public void makeExits() {
	    this.rooms.put("up",Game.roomList.get("opticaldrive"));
	    rooms.put("south", Game.roomList.get("chipset"));
	}
	
}
