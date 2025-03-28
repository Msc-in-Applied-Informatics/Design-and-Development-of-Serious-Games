import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerImage extends Actor
{
    GreenfootImage spriteSheet = new GreenfootImage("players/People1.png");
    GreenfootImage player;
    public PlayerImage(){
        createPlayerImage();
    }
    public void createPlayerImage(){
        int spriteWidth = 192/4;
        int spriteHeight = 192/4;
        int x = 0;
        int y = 0;
        
        player = new GreenfootImage(spriteWidth,spriteHeight);
        player.drawImage(spriteSheet,-x*spriteWidth,-y*spriteHeight);
        setImage(player);
        getImage().scale(45,45);
    }
    public void act()
    {
        // Add your action code here.
    }
}
