package engine;

import java.util.HashMap;

import items.*;
import rooms.*;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game {

    private Parser parser;
    private Player player;
    public static HashMap<String,Item> itemList = new HashMap<String,Item>();
    public static HashMap<String,Room> roomList = new HashMap<String,Room>();
    public static Game instance;
    public static boolean run = true;
    
    public static void main(String... args) {
        new Game().play();
    }

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createWorld();
        parser = new Parser();
        Game.instance=this;
    }

    /**
     * Creates all the rooms and items.
     */
    private void createWorld() {
    	Item laser = new Laser();
    	itemList.put("laser", laser);
    	Item upgradedLaser = new UpgradedLaser();
    	itemList.put("upgradedlaser", upgradedLaser);
    	Item capacitor = new Capacitor();
    	itemList.put("capacitor", capacitor);
    	Item copper = new Copper();
    	itemList.put("copper", copper);
    	
    	Room opticaldrive = new OpticalDriveRoom();
    	roomList.put("opticaldrive", opticaldrive);
    	Room satahub = new SATAHub();
    	roomList.put("satahub", satahub);
    	Room chipset = new ChipsetRoom();
    	roomList.put("chipset", chipset);
    	Room cpu = new CPURoom();
    	roomList.put("cpu", cpu);
    	Room graphicscard = new GraphicsCardRoom();
    	roomList.put("graphicscard", graphicscard);
    	Room networkcard = new NetworkCardRoom();
    	roomList.put("networkcard", networkcard);
    	Room pciehub = new PCIeHubRoom();
    	roomList.put("pciehub",pciehub);
    	Room powersupply = new PowerSupplyRoom();
    	roomList.put("powersupply",powersupply);
    	Room soundcard = new SoundCardRoom();
    	roomList.put("soundcard",soundcard);
    	Room speaker = new SpeakerRoom();
    	roomList.put("speaker", speaker);
    	
    	
    	
    	for (Room r : roomList.values()) r.makeExits();
    	player = new Player(opticaldrive);
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.

        while (run) {
            if (parser.runNextCommand()) break;
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getRoom().getDescription());
    }

    public Player getPlayer() {
        return player;
    }
}
