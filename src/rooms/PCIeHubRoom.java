package rooms;

import engine.*;

public class PCIeHubRoom extends Room {

    static String desc = "Much ports, much options, seems as if there is graphics card, and a network card installed; has to be the PCIe hub.";
    
	public PCIeHubRoom() {
		super(desc);
	}

	public void makeExits() {
	    rooms.put("east",  Game.roomList.get("networkcard"));
	    rooms.put("southwest", Game.roomList.get("powersupply"));
	    rooms.put("southeast", Game.roomList.get("soundcard"));
	    rooms.put("south", Game.roomList.get("graphicscard"));
	}
	
}
