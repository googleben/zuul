package engine;

import java.util.ArrayList;

public class Player {
    
    private Room currRoom;
    private ArrayList<Item> items;
    
    public Player(Room room) {
        currRoom = room;
        this.items = new ArrayList<Item>();
    }
    
    public void move(String dir) {
        this.currRoom = currRoom.travel(dir).init(currRoom);
    }
    
    public Room getRoom() { return currRoom; }
    public void setRoom(Room r) { this.currRoom = r; }
    
    public void addItem(Item i) { items.add(i); }
    public void removeItem(Item i) { items.remove(i); }
    public void replaceItem(Item orgin, Item replacement) { items.set(items.indexOf(orgin), replacement);}
    public boolean hasItem(Item i) { return items.contains(i); }

}
