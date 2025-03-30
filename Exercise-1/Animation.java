import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animation extends Actor
{
     GreenfootImage spriteSheet = new GreenfootImage("find-something3.png");       
        private long lastFrameTime = 0;
        private int frameDelay = 500; 
 
    public Animation() 
    {
       
        setImage(spriteSheet);
        getImage().scale(50,50);
    } 
   
    
    /**
     * Explode!
     */
    public void act()
    { 
        if (System.currentTimeMillis() - lastFrameTime > frameDelay){

            setImage(spriteSheet);
        
            getImage().scale(30,30);
        
                getWorld().removeObject(this);

            lastFrameTime = System.currentTimeMillis();
        }
    }
}
