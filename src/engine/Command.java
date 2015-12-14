package engine;
import java.util.HashMap;


public class Command {

    public CommandFunction function;
    public String help;
    public static HashMap<String,Command> commands;

    public Command(CommandFunction function, String help) {
        this.function = function;
        this.help = help;
    }

    public void run(String[] args) {
        if (!function.run(args)) System.out.println("You used this command incorrectly! Here's how to use it:\n" + help);
    }

    public static HashMap<String, Command> getCommands() {
        HashMap<String, Command> ans = new HashMap<String, Command>();

        ans.put("move", new Command(Command::move, "move <direction>"));
        ans.put("go", new Command(Command::move, "go <direction>"));
        ans.put("look", new Command(Command::look, "look"));
        ans.put("pickup", new Command(Command::pickup, "pickup <item>"));
        ans.put("help", new Command(Command::help, "help [command]"));
        
        Command.commands = ans;
        return ans;
    }
    
    public static boolean help(String... args) {
        if (!(args.length==1 || args.length==0)) return false;
        if (args.length==1) {
            if (!commands.containsKey(args[0])) {
                System.out.println(args[0]+" is not a command!");
                return true;
            }
            System.out.println(commands.get(args[0]).help);
        } else for (Command c : commands.values()) System.out.println(c.help);
        return true;
    }

    public static boolean move(String... args) {
        Player player = Game.instance.getPlayer();
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

    public static boolean look(String... args) {
        if (args.length != 0) return false;
        System.out.println(Game.instance.getPlayer().getRoom().getDescription());
        return true;
    }
    
    public static boolean pickup(String... args) {
    	if (args.length!=1) return false;
    	if (Game.instance.getPlayer().getRoom().containsItem(args[0])) {
    	    Game.instance.getPlayer().addItem(Game.instance.getPlayer().getRoom().removeItem(args[0]));
    	    System.out.println("You pick up the "+args[0]+".");
    	} else System.out.println("You don't see a "+args[0]+" anywhere.");
    	return true;
    }

}
