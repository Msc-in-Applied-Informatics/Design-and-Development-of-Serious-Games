import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Actor
{
    GreenfootImage image = new GreenfootImage("egg.png");
    public Egg(int size){
       setImage(image);
       getImage().scale(size,size);
    }
    
    public void act()
    {
        
    }
}
