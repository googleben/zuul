package rooms;

import engine.*;

public class GraphicsCardRoom extends Room {

	public GraphicsCardRoom(String description) {
		super(description);
		override.put("upgrade", new Command(this::upgrade, "upgrade [item]"));
	}

	public boolean upgrade(Game g, String args[]){
		if (args.length!=1) return false;
		if (args[0].equals("laser")){
			g.getPlayer().upgradeItem(Game.itemList.get("laser"), Game.itemList.get("upgradeLaser"));
		}
		System.out.println("You upgraded the laser.");
		return true;
	}

}
