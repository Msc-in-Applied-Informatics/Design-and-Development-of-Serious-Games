import java.util.ArrayList;
import java.util.Iterator;
import greenfoot.World;
import java.util.List;

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory  
{

    private static Inventory instance;
    private ArrayList<ItemData> inventoryItems; //Inventory
    private ArrayList<ItemData> items; // start Items out
    private ArrayList<ItemData> insideItems; // inside home
    private int useItems = 0;

    private Inventory() {
        inventoryItems = new ArrayList<>();
        items = new ArrayList<>();
        insideItems = new ArrayList<>();
    }
    
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    
    // Add Item when press "F" in inventory
    public void pickUpItem(Item item) {
        ItemData newItem = new ItemData(item.getCol(), item.getRow(), item.getSpritePath(), item.getX(), item.getY());
        inventoryItems.add(newItem);
        removeItemFromWorld(newItem);
    }
    
    private void removeItemFromWorld(ItemData data){
        if(!items.isEmpty()){
          items.removeIf(inventory -> data.getCol() == inventory.getCol() && data.getRow() == inventory.getRow());
        }
        
        if(!insideItems.isEmpty()){
           insideItems.removeIf(inventory -> data.getCol() == inventory.getCol() && data.getRow() == inventory.getRow());
        }
    }
    
    private void removeFromInventory(Item item){
      if (!inventoryItems.isEmpty()) {
       inventoryItems.removeIf(inventory -> item.getCol() == inventory.getCol() && item.getRow() == inventory.getRow());
      }
    }

    // Check if there is item in inventory
    public boolean hasItem(int col, int row) {        
        if(!inventoryItems.isEmpty()){
            for(ItemData item: inventoryItems){
                if(item.getCol() == col && item.getRow() == row){
                    return true;
                }
            }
        }
        return false;
    }
    //Return all Items
    public ArrayList<ItemData> getItems() {
        return items;
    }
    //Clear History all
    public void clearInventory() {
        //if(inventoryItems.size() >0)
            inventoryItems.clear();
        //if(items.size() > 0)
            items.clear();
        //if(insideItems.size() > 0)
            insideItems.clear();
            
        useItems = 0;
    }
    
    public void addItem(Item item){
        items.add(new ItemData(item.getCol(), item.getRow(), item.getSpritePath(), item.getX(),item.getY()));  
    }
    
    public void addInsideHomeItem(Item item){
         insideItems.add(new ItemData(item.getCol(), item.getRow(), item.getSpritePath(), item.getX(),item.getY()));  
    }
    // created and remove from list when press "D"
    public void setDown(Item item, World world){
       removeFromInventory(item);
       
       if(world instanceof World1){
           addItem(item);
       }else if(world instanceof InsideHome){
           addInsideHomeItem(item);
       }
    }
    // Return Inside Home items
    public ArrayList<ItemData> getInsideItems(){
        return insideItems;
    }
    // Remove Inside home item
    public void removeInsideItem(ItemData item){
        insideItems.remove(item);
    }
    // Return inventory items
    public ArrayList<ItemData> getInventory(){
        return inventoryItems;
    }
    
    public boolean foundInsideHome(int col,int row){
        if(!insideItems.isEmpty()){
            for(ItemData item: insideItems){
                if(item.getCol() == col && item.getRow() == row){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void useItem(){
        useItems++;
    }
    public int getUsedItems(){
        return useItems;
    }
    
    public void cancelUseItem(){
        if(useItems> 0 )
            useItems--;
    }
}
