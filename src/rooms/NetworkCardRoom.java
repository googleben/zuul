package rooms;

import engine.*;

public class NetworkCardRoom extends Room {

    static String desc = "";
    
    public boolean canLeave;
    
	public NetworkCardRoom(String description) {
		super(desc);
		override.put("use", new Command(this::use, "use [item]"));
		override.put("leave", new Command(this::leave, "leave"));
		this.canLeave = false;
	}

	public boolean use(String[] args) {
		if (args.length!=1) return false;
		if (!args[0].equals("capacitor")){
			System.out.println("You don't use "+args[0]+ " here");
			return false;
		}
		else if (args[0].equals("capacitor")) {
			System.out.println("You place the capacitor to complete the wiring making it possible to leave the computer.");
		}
		return true;
	}
	
	public boolean leave(String[] args) {
	    if (args.length!=0) return false;
	    if (canLeave) {
	        System.out.println("You leave the computer and return to the real world.");
	        Game.run = false;
	    } else System.out.println("The network card is missing a capacitor; you can't leave.");
	    return true;
	}

}
