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
    public boolean runNextCommand(Game game) {
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
        if (cmd.equals("quit")) return true;
        
        Command c = commands.get(cmd);
        c.run(game, args);
        return false;
    }
}
