import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EqualSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EqualSymbol extends Actor
{
    GreenfootImage image = new GreenfootImage("equal-symbol.png");
    public EqualSymbol(int size){
       setImage(image);
       getImage().scale(size,size);
       
    }
    public void act()
    {
        // Add your action code here.
    }
}
