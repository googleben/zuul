package rooms;

import engine.*;

public class SoundCardRoom extends Room {

	public SoundCardRoom(String description) {
		super(description);
		override.put("use", new Command(this::use, "use [item]"));
		this.isLocked = true;
	}
	
	@Override
	public Room init(Room r){
		if (Game.instance.getPlayer().hasItem(Game.itemList.get("Upgradedlaser"))) {
			this.isLocked = false;
			System.out.println("The Dragon has been destroyed!");
			return rooms.get("SoundCardRoom");
		} else if (Game.instance.getPlayer().hasItem(Game.itemList.get("laser"))) {
			this.isLocked = true;
			System.out.println("You need an upgraded laser");
		}
		return r;
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
