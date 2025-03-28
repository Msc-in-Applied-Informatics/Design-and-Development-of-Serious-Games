import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fountain extends Tile
{
    private int countPixel = 2; 
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    private int spriteWidth = 612/(19*countPixel);
    private int spriteHeight = 576/(18*countPixel);
    
    private int xPosImage;
    private int yPosImage;
    private int backStep = 0;
    
    private long lastFrameTime = 0;
    private int frameDelay = 100; // Καθυστέρηση 100ms  
    public Fountain(int width,int height, String path, String type, int theTypeTile,int xSprite,int ySprite){
       super(width,height,path,type,theTypeTile);
       xPosImage = xSprite;
       yPosImage = ySprite;
       super.updateSprite(xSprite,ySprite);
       //setDimensions();
       //createFountain();
    }
    
    public void act()
    {    
        if(System.currentTimeMillis() - lastFrameTime > frameDelay){
            if(backStep == 2){
                 xPosImage  = xPosImage -6;
                 backStep = 0;
            }else {
                xPosImage = xPosImage + 3;
                
                backStep++;
              
            }
            super.updateSprite(xPosImage,yPosImage);
            lastFrameTime = System.currentTimeMillis();
        }
        
    }

    
    private void setDimensions(){
        super.setTileSize(32);
        super.setCountPixel(4);
        super.setSpriteWidthAndHeight(612, 576, 19, 18);
    }
    
    private void createFountain(){
        super.createDynamicSprite(12, 4, 1, 60, 60,-15,-30);    
    }
    
}
