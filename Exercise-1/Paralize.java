import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paralize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paralize extends Actor
{
  /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 4;
    
    private int spriteWidth = 480/5;
    private int spriteHeight = 288/3;
    private static GreenfootImage[] sprites1;
    private static GreenfootImage[] sprites2;
    private static GreenfootImage[] sprites3;
    private long lastFrameTime = 0;
    private int frameDelay = 0; 
    /** Current size of the explosion */
    private int imageNo = 0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;
    
    /**
     * Create a new explosion.
     */
    public Paralize() 
    {
       
        initializeImages();
        setImage(sprites3[0]);
        getImage().scale(50,50);
        //Greenfoot.playSound("MetalExplosion.wav");
    } 
        
    /** 
     * Create the images for explosion.
     */
    public synchronized static void initializeImages() 
    {
        if(sprites1 == null || sprites2 == null  || sprites3 == null) {
            GreenfootImage spriteSheet = new GreenfootImage("/sprites/Paralysis-no-bg.png");
            int columns = 5;
            int rows = 3;
            int spriteWidth = 480/columns;
            int spriteHeight = 288/rows;
            sprites1 = new GreenfootImage[columns];
            sprites2 = new GreenfootImage[columns];
            sprites3 = new GreenfootImage[columns];
            
            for (int col = 0; col < columns; col++) {
                //1st line
                sprites1[col] = new GreenfootImage(spriteWidth, spriteHeight);
                sprites1[col].drawImage(spriteSheet, -col * spriteWidth, 0);
                //2nd line
                sprites2[col] = new GreenfootImage(spriteWidth, spriteHeight);
                sprites2[col].drawImage(spriteSheet, -col * spriteWidth, -spriteHeight);
                //3rd line
                sprites3[col] = new GreenfootImage(spriteWidth, spriteHeight);
                sprites3[col].drawImage(spriteSheet, -col * spriteWidth, -2 * spriteHeight);
            }
        }
    }
    
    /**
     * Explode!
     */
    public void act()
    { 
        if (System.currentTimeMillis() - lastFrameTime > frameDelay){

            setImage(sprites3[imageNo]);
        
            getImage().scale(100,100);
        
            imageNo += increment;
            if(imageNo >= IMAGE_COUNT) {
                increment = -increment;
                imageNo += increment;
            }
        
        
            if (imageNo < 0) {
                getWorld().removeObject(this);
            }
            lastFrameTime = System.currentTimeMillis();
        }
    }
}
