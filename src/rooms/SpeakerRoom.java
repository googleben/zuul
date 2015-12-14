package rooms;

import engine.*;

/**
 * Created by Rohith on 12/4/15.
 */
public class SpeakerRoom extends Room {

    static String desc = "";
    
    public SpeakerRoom(String description) {
        super(desc);
        override.put("pickup", new Command(this::pickup,"pickup [item]"));
        this.isLocked = true;
    }

    public boolean pickup(String args[]) {
        if (args.length!=1) return false;
        if (args[0].equals("capacitor")){
            System.out.println("You don't see a "+args[0]+ " anywhere");
            return true;
        }
        Game.instance.getPlayer().addItem(Game.itemList.get("capacitor"));
        System.out.println("You picked up the capacitor.");
        return true;
    }
    


}
