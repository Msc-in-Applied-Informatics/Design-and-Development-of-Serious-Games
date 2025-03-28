import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Animal
{
    public Snake(){
        setSprite("animals/Monsters-no-bg.png");
        createSprite(4,6, 30,30);
    }
    
    private final static int SPEEDVARIATION = 3;
    private final static int SPEEDCHANGECHANCE = 10;
    
    private int lastPos = 6;
    // X = [3,4,5] , Y = [4,5,6,7]
    private int animationIndex = 4;
    private int frameCounter = 0;
    
    private long lastFrameTime = 0;
    private int frameDelay = 3000;    
    
    protected void reaction() {
        if (Greenfoot.getRandomNumber(30) == 0) { 
            if (Greenfoot.getRandomNumber(5) == 0) {
                speedX = 0;
                speedY = 0;
            } else {
                speedX = Greenfoot.getRandomNumber(3) - 1;  
                speedY = Greenfoot.getRandomNumber(3) - 1;  
                if (speedX != 0 && speedY != 0) {
                    if (Greenfoot.getRandomNumber(2) == 0) {
                        speedX = 0;
                    } else {
                        speedY = 0;
                    }
                }
            }
        }
    }
    private int test = 1;
    protected void seeSomething(){
        if(canSee(Player.class)){
            if (System.currentTimeMillis() - lastFrameTime > frameDelay){
                Player player = (Player) getOneObjectAtOffset(0, 0, Player.class);
                World1 world = (World1) getWorld();
                world.addObject(new Paralize(), player.getX(), player.getY());
            //if(test == 1){
                player.getDamage(10);
                 //test=0;   
          //  }
          
               lastFrameTime = System.currentTimeMillis();
            }
           
        }
    }
    
    protected void animate(){
        frameCounter++;

        if (frameCounter % 5 == 0) {  
            animationIndex = (animationIndex + 1) % 3 +3; 

            GreenfootImage currentSprite = null; 

            if (speedX > 0) {  
                currentSprite = getSpriteFrame(animationIndex, 5);
                lastPos = 5;
            } else if (speedX < 0) {  
                currentSprite = getSpriteFrame(animationIndex, 7);
                lastPos = 7;
            } else if (speedY > 0) {  
                currentSprite = getSpriteFrame(animationIndex, 6);
                lastPos = 6;
            } else if (speedY < 0) {  
                currentSprite = getSpriteFrame(animationIndex, 4);
                lastPos = 4;
            }else{
                animationIndex = 4;
                currentSprite = getSpriteFrame(animationIndex,lastPos);
            }

            if (currentSprite != null) {
                setImage(currentSprite);  
                getImage().scale(30,30);
            }
        }
    }
}
