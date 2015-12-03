package engine;
@FunctionalInterface
public interface CommandFunction {
    
    
    /**
     * @param player the Player
     * @param args command arguments
     * @return returns false if command is incorrectly used, true otherwise
     */
    public boolean run(Game game, String... args);
    
}

