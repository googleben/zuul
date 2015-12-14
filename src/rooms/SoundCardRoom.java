package rooms;

import engine.*;


public class SoundCardRoom extends Room {

    static String desc = "All these audio ports, the dragon remains, and some capacitors… it has to be the sound card. There seems to be a path to the speakers, but needs some copper.";
    
	public SoundCardRoom() {
		super(desc);
		this.isLocked = true;
		use.put(Game.itemList.get("copper"), () -> {
		    if (!Game.instance.getPlayer().hasItem(Game.itemList.get("copper")));
            System.out.println("You place the copper to complete the wiring making it possible to get inside the speaker.");
            Game.roomList.get("speaker").isLocked = false;
		    return true;
		});
	}
	
	@Override
	public Room init(Room r){
		if (Game.instance.getPlayer().hasItem(Game.itemList.get("upgradedlaser"))) {
			this.isLocked = false;
			System.out.println("The Dragon has been destroyed!");
			return this;
		} else if (Game.instance.getPlayer().hasItem(Game.itemList.get("laser"))) {
			this.isLocked = true;
			System.out.println("You need an upgraded laser");
		}
		return r;
	}
	
	public void makeExits() {
	    rooms.put("northwest", Game.roomList.get("pciehub"));
	    rooms.put("east", Game.roomList.get("speaker"));
	}

}
