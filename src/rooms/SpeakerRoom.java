package rooms;

import engine.*;

/**
 * Created by Rohith on 12/4/15.
 */
public class SpeakerRoom extends Room {

    public SpeakerRoom(String description) {
        super(description);
        override.put("pickup", new Command(this::pickup,"pickup [item]"));
        override.put("use", new Command(this::use, "use [item]"));
    }

    public boolean pickup(Game g, String args[]) {
        if (args.length!=1) return false;
        if (args[0].equals("capacitor")){
            System.out.println("You don't see a "+args[0]+ " anywhere");
            return true;
        }
        g.getPlayer().addItem(Game.itemList.get("capacitor"));
        System.out.println("You picked up the capacitor.");
        return true;
    }
    
    public boolean use(Game g, String args[]) {
    	if (args.length!=1) return false;
    	if (!args[0].equals("copper")){
            System.out.println("You don't use "+args[0]+ " here");
            return false;
        }
    	else if (args[0].equals("copper"))
    		System.out.println("You place the copper to complete the wiring making it possible to get inside.");
    	return true;
    }

}
