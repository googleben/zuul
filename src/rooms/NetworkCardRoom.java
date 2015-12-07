package rooms;

import engine.*;

public class NetworkCardRoom extends Room {

	public NetworkCardRoom(String description) {
		super(description);
		override.put("use", new Command(this::use, "use [item]"));
	}

	public boolean use(Game g, String args[]) {
		if (args.length!=1) return false;
		if (!args[0].equals("capacitor")){
			System.out.println("You don't use "+args[0]+ " here");
			return false;
		}
		else if (args[0].equals("capacitor"))
			System.out.println("You place the capacitor to complete the wiring making it possible to leave the computer.");
		return true;
	}

}
