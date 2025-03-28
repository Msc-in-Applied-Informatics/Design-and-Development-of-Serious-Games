import java.util.ArrayList;

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory  
{

    private static Inventory instance;
    private ArrayList<ItemData> items;

    private Inventory() {
        items = new ArrayList<>();
    }
    
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    
    public void addItem(Item item) {
        if (!hasItem(item.getCol(), item.getRow())) {
            items.add(new ItemData(item.getCol(), item.getRow(), item.getSpritePath()));
        }
    }

    public boolean hasItem(int col, int row) {
        for (ItemData data : items) {
            if (data.getCol() == col && data.getRow() == row) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ItemData> getItems() {
        return items;
    }
    
    public void clearInventory() {
        items.clear();
    }
}
