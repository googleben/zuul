package rooms;

import engine.*;

/**
 * Created by Rohith on 12/4/15.
 */
public class SpeakerRoom extends Room {

    static String desc = "OH NO CANCER IS EVERYWHERE, it has to be a Beats Speaker … smh. There seems to be a capacitor lying around.";
    
    public SpeakerRoom() {
        super(desc);
        items.put("capacitor", Game.itemList.get("capacitor"));
        this.isLocked = true;
    }
    
    public Room init(Room r) {
        if (isLocked) {
            System.out.println("The connection to the speakers is missing - You need some copper!");
            return r;
        }
        return this;
    }
    
    public void makeExits() {
        rooms.put("west", Game.roomList.get("soundcard"));
    }

}
