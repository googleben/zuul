package rooms;

import engine.*;

/**
 * Created by Rohith on 12/3/15.
 */
public class PowerSupplyRoom extends Room {

    public PowerSupplyRoom(String description) {
        super(description);
        override.put("pickup", new Command(this::pickup,"pickup [item]"));
    }

    public boolean pickup(Game g, String args[]) {
        if (args.length!=1) return false;
        if (args[0].equals("copper")){
            System.out.println("You don't see a "+args[0]+ " anywhere");
            return true;
        }
        g.getPlayer().addItem(Game.itemList.get("copper"));
        System.out.println("You picked up the copper.");
        return true;
    }

}
