import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    private int spriteWidth = 288/12;
    private int spriteHeight = 256/8;
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    
    private long lastFrameTime = 0;
    private int frameDelay = 800;  
    
    public Item(int col, int row){
        setSprite("/sprites/food-no-bg.png");
        createSprite(col,row,50,50);
    }
    
    public void setSprite(String path){
         spriteSheet = new GreenfootImage(path);
    }
    
    public void createSprite(int col, int row,int scaleX,int scaleY){
        currentSprite = new GreenfootImage(spriteWidth,spriteHeight);
        currentSprite.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        setImage(currentSprite);
        getImage().scale(scaleX,scaleY);
    }
    
    public void act(){    }    
    
    public int getCol() { return spriteWidth; } 
    public int getRow() { return spriteHeight; }
    public String getSpritePath() { return "/sprites/food-no-bg.png"; }
}
