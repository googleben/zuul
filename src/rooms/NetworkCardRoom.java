package rooms;

import engine.*;

public class NetworkCardRoom extends Room {

    static String desc = "There seems to be an ethernet port and wireless receiver has to be the Network card. Sadly it’s missing a capacitor so you're stuck in here for now.";
    
    public boolean canLeave;
    
	public NetworkCardRoom() {
		super(desc);
		override.put("leave", new Command(this::leave, "leave"));
		use.put(Game.itemList.get("capacitor"), () -> {
		    System.out.println("You place the capacitor to complete the wiring making it possible to leave the computer.");
            canLeave = true;
		    return true;
		});
		this.canLeave = false;
	}
	
	public boolean leave(String[] args) {
	    if (args.length!=0) return false;
	    if (canLeave) {
	        System.out.println("You leave the computer and return to the real world.");
	        Game.run = false;
	    } else System.out.println("The network card is missing a capacitor; you can't leave.");
	    return true;
	}
	
	public void makeExits() {
	    rooms.put("west", Game.roomList.get("pciehub"));
	}

}
