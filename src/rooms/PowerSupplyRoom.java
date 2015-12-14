package rooms;

import engine.*;

public class PowerSupplyRoom extends Room {

    static String desc = "";
    
    public PowerSupplyRoom(String description) {
        super(desc);
        override.put("pickup", new Command(this::pickup,"pickup [item]"));
        this.isLocked = true;
    }

    public boolean pickup(String args[]) {
        if (args.length!=1) return false;
        if (args[0].equals("copper")){
            System.out.println("You don't see a "+args[0]+ " anywhere");
            return true;
        }
        Game.instance.getPlayer().addItem(Game.itemList.get("copper"));
        System.out.println("You picked up the copper.");
        return true;
    }

}
