import java.util.ArrayList;
import java.util.Iterator;

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
    private ArrayList<ItemData> tookItems;
    private ArrayList<InsideItemData> usedItems;
    private int currentItemIndex = 0;

    private Inventory() {
        items = new ArrayList<>();
        tookItems = new ArrayList<>();
        usedItems = new ArrayList<>();
    }
    
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    
    public void addItem(Item item) {
        //if (!hasItem(item.getCol(), item.getRow())) {
            items.add(new ItemData(item.getCol(), item.getRow(), item.getSpritePath()));
            tookItems.add(new ItemData(item.getCol(), item.getRow(), item.getSpritePath()));
        //}
    }

    public boolean hasItem(int col, int row) {
        if(tookItems != null && !tookItems.isEmpty()){
            for (ItemData data : tookItems) {
                if (data.getCol() == col && data.getRow() == row) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<ItemData> getItems() {
        return tookItems;
    }
    
    public void clearInventory() {
        if(items.size() >0)
            items.clear();
        if(tookItems.size() > 0)
            tookItems.clear();
        if(usedItems.size() > 0)
            usedItems.clear();
    }
    
    public void useItem(Item item, int x, int y){
       Iterator<ItemData> iterator = items.iterator();
        while (iterator.hasNext()) {
            ItemData data = iterator.next();
            if (data.getCol() == item.getCol() && data.getRow() == item.getRow()) {
                usedItems.add(new InsideItemData(data, x,y));
                iterator.remove();
                break; 
            }
        }
    }
    
    public ArrayList<InsideItemData> getUsedItems(){
        return usedItems;
    }

    public ArrayList<ItemData> getInventory(){
        return items;
    }
}
