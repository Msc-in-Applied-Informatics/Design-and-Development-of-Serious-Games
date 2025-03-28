import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rain extends Weather
{
    public Rain() {
        GreenfootImage drop = new GreenfootImage(3, 10);
        drop.setColor(Color.BLUE);
        drop.fillOval(0, 0, 3, 10);
        setRotation(0);
        setImage(drop);
    }

    public void act() {
        // use for snow  Greenfoot.getRandomNumber(10)
        setLocation(getX() + 2, getY() + 5); 

        if (getY() >= getWorld().getHeight()-30 || getX() >= getWorld().getWidth()-230)  {  
            getWorld().removeObject(this); 
        }
    }       
}
