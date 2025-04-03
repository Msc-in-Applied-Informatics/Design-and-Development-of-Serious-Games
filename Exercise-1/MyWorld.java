import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private GreenfootSound backgroundMusic = new GreenfootSound("2003Fairy Forest.mid"); 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        //Player player = new Player();
        //addObject(player, getWidth()/2 + 100, getHeight()/2);
        reset();
        displayDescription();
        //Greenfoot.setWorld(new World1());
        //Greenfoot.setWorld(new InsideHome(new Player(new Life())));
        backgroundMusic.playLoop();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new World1());
            backgroundMusic.stop();
        }
    }
    
    public void displayDescription(){
         addObject(new Description(), getWidth()/2, getHeight()/2);
    }
    
    private void reset() {
        State.getInstance().resetState();        
        Inventory.getInstance().clearInventory();
    }
}
