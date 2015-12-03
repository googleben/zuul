package rooms;

import engine.*;

public class OpticalDriveRoom extends Room {

	public OpticalDriveRoom(String description) {
		super(description);
		override.put("pickup", new Command(this::pickup, "pickup [item]"));
	}
	
	public boolean pickup(Game g, String[] args) {
		if (args.length!=1) return false;
		if (args[0]!="laser") {
			System.out.println("You don't see a "+args[0]+" anywhere.");
			return true;
		}
		g.getPlayer().addItem(Game.itemList.get("laser"));
		System.out.println("You picked up the laser.");
		return true;
	}
	
	
	
}
