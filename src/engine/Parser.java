package engine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser 
{
    private HashMap<String, Command> commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = Command.getCommands();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public boolean runNextCommand() {
        String inputLine;   // will hold the full input line
        String[] args = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        String cmd = tokenizer.next();
        ArrayList<String> argsList = new ArrayList<String>();
        while (tokenizer.hasNext()) {
            argsList.add(tokenizer.next());
        }
        tokenizer.close();
        args = argsList.toArray(new String[0]);
        if (cmd.equals("quit")) return true;
        
        Command c = commands.get(cmd);
        if (Game.instance.getPlayer().getRoom().override.containsKey(cmd)) c = Game.instance.getPlayer().getRoom().override.get(cmd);
        c.run(args);
        return false;
    }
}
