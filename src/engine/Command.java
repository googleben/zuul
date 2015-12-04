package engine;
import java.util.HashMap;


public class Command {

    public CommandFunction function;
    public String help;

    public Command(CommandFunction function, String help) {
        this.function = function;
        this.help = help;
        //testing github
    }

    public void run(Game game, String[] args) {
        if (!function.run(game, args)) System.out.println("You used this command incorrectly! Here's how to use it:\n" + help);
    }

    public static HashMap<String, Command> getCommands() {
        HashMap<String, Command> ans = new HashMap<String, Command>();

        ans.put("move", new Command(Command::move, "move [direction]"));
        ans.put("look", new Command(Command::look, "look"));

        return ans;
    }

    public static boolean move(Game game, String... args) {
        Player player = game.getPlayer();
        if (args.length != 1) return false;
        String dir = args[0];
        if (!player.getRoom().hasRoom(dir)) {
            System.out.println("You cannot move " + dir + ".");
            return true;
        }
        player.move(dir);
        System.out.println(player.getRoom().getDescription());

        return true;
    };

    public static boolean look(Game game, String... args) {
        if (args.length != 0) return false;
        System.out.println(game.getPlayer().getRoom().getDescription());
        return true;
    }
    
    public static boolean pickup(Game game, String... args) {
    	if (args.length!=1) return false;
    	System.out.println("You don't see a "+args[0]+" anywhere.");
    	return true;
    }

}
