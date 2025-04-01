import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class X here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class X extends Actor
{
    GreenfootImage image = new GreenfootImage("x.png");
    public X(int size){
       setImage(image);
       getImage().scale(size,size);
    }
    public void act()
    {
        // Add your action code here.
    }
}
