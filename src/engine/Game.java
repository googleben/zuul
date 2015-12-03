package engine;

import java.util.ArrayList;
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

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createWorld();
        parser = new Parser();
    }

    /**
     * Creates all the rooms and items.
     */
    private void createWorld() {
    	Item laser = new Laser();
    	itemList.put("laser", laser);
    	Room opticaldrive = new OpticalDriveRoom("You are in an optical drive. You think you can take the laser out of the drive.");
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.

        while (1 != 0) {
            if (parser.runNextCommand(this)) break;
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
