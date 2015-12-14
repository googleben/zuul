package rooms;

import engine.*;

public class CPURoom extends Room {

    static String desc = "Seems the CPU is a x86 version, obviously 64 bit. Ooooooooh its the 18 core Xeon...fancy.";
    
	public CPURoom() {
		super(desc);
	}
	
	public void makeExits() {
	    rooms.put("north", Game.roomList.get("chipset"));
	    rooms.put("down", Game.roomList.get("powersupply"));
	}

}
