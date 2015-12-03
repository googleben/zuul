

public class Player {
    
    public Room currRoom;
    public Item[] items;
    
    public void move(String dir) {
        this.currRoom = currRoom.travel(dir);
    }
    
}
