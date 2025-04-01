import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attention here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attention extends Actor
{
     GreenfootImage spriteSheet = new GreenfootImage("attention.png");       
        private long lastFrameTime = 0;
        private int frameDelay = 500; 
 
    public Attention() 
    {
       
        setImage(spriteSheet);
        getImage().scale(40,40);
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
