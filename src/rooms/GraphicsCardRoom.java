package rooms;

import engine.*;

public class GraphicsCardRoom extends Room {

    static String desc = "This pretty graphics card that was protected by the SPU seems to a Titan X, very nice. Doesn’t look like it has power, such tragedy.";
    
	public GraphicsCardRoom() {
		super(desc);
		this.isLocked = true;
	}

	@Override
	public Room init(Room r) {
		if (Game.instance.getPlayer().hasItem(Game.itemList.get("laser"))) {
			this.isLocked = false;
			System.out.println(
					"The Rogue SPU has been destroyed, and your laser has been upgraded.");
			Game.instance.getPlayer().replaceItem(Game.itemList.get("laser"), Game.itemList.get("upgradedlaser"));
			return this;
		} else {
			System.out.println("You attempt to fight a rouge SPU, but it proves stronger than your fists.");	
			return r;
		}
	}
	
	public void makeExits() {
	    rooms.put("north", Game.roomList.get("pciehub"));
	}

}
