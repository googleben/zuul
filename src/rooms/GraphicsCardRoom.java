package rooms;

import engine.*;

public class GraphicsCardRoom extends Room {

    static String desc = "";
    
	public GraphicsCardRoom(String description) {
		super(desc);
		this.isLocked = true;
	}

	@Override
	public Room init(Room r) {
		if (Game.instance.getPlayer().hasItem(Game.itemList.get("laser"))) {
			this.isLocked = false;
			System.out.println(
					"The Rogue SPU has been destroyed, and your laser has been upgraded to fight other things");
			Game.instance.getPlayer().replaceItem(Game.itemList.get("laser"), Game.itemList.get("upgradedLaser"));
			return rooms.get("GraphicsCardRoom");
		} else {
			System.out.println("You need the Laser to enter this room");	
			return r;
		}
	}

}
