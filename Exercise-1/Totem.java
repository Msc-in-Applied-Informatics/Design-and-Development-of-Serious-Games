import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Totem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Totem extends Actor
{
    private int spriteWidth = 288/12;
    private int spriteHeight = 256/8;
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    
    public Totem(){
        setSprite("/sprites/Spear-no-bg.png");
        createSprite(9,0,80,80);
    }
    
    public void setSprite(String path){
         spriteSheet = new GreenfootImage(path);
    }
    
    public void createSprite(int col, int row,int scaleX,int scaleY){
        currentSprite = new GreenfootImage(spriteWidth,spriteHeight);
        currentSprite.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        setImage(currentSprite);
        getImage().scale(scaleX,scaleY);
    }
    
    public void act()
    {
        lookForActiveSouls();
    }
    
    
     public void lookForActiveSouls(){
        World world = (InsideHome) getWorld();
        
        int counter = Inventory.getInstance().getUsedItems();
        //int counter = world.getObjects(Item.class).size();
        switch(counter){
            case 0:
                createSprite(9, 0,80,80);
                break;
            case 1:
                createSprite(6, 2,80,80);
                break;
            case 2:
                  createSprite(7, 2,80,80);
                break;                
            case 3:
                  createSprite(8, 2,80,80);
                break;
            case 4:
                  createSprite(7, 1,80,80);
                break;
            default: break;
        }
    }
}
