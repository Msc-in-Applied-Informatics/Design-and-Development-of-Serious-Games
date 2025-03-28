import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    private GreenfootImage spriteSheet = new GreenfootImage("sprites/food-no-bg.png");
    private int spriteWidth = 288/12;
    private int spriteHeight = 256/8;
    GreenfootImage player;
    public Food(int col, int row){
        createFoodImage(col,row);
    }
    public void createFoodImage(int x, int y){
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
