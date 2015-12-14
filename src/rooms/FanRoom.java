package rooms;

import engine.*;

public class FanRoom extends Room{

    static String desc = "Woah blades … ahh its the fan. ERMAGHERD, THE DUST,  my allergies are kicking up…";
    
	public FanRoom() {
		super(desc);
	}
	
	public void makeExits() {
	    rooms.put("west", Game.roomList.get("chipset"));
	}
	
}
