

public class Player {
    
    private Room currRoom;
    public Item[] items;
    
    public void move(String dir) {
        this.currRoom = currRoom.travel(dir);
    }
    
    public Room getRoom() { return currRoom; }
    public void setRoom(Room r) { this.currRoom = r; }
    
}
