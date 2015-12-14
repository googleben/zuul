package rooms;

import engine.*;

public class PowerSupplyRoom extends Room {

    static String desc = "Such tuff capacitors, such cool capacitors, with all these power cables and massive capacitors  it has to be the power supply. There seems to be some copper lying around.";
    
    public PowerSupplyRoom() {
        super(desc);
        items.put("copper",Game.itemList.get("copper"));
        this.isLocked = true;
    }
    
    public void makeExits() {
        rooms.put("up", Game.roomList.get("cpu"));
        rooms.put("northeast", Game.roomList.get("pciehub"));
    }

}
