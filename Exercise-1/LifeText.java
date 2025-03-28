import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeText extends Actor
{
    private GreenfootImage image;
    
    public LifeText(){
        image = new GreenfootImage("life-no-bg.png");
        image.scale(80, 90);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
