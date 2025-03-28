import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chicken extends Animal
{
    public Chicken(){
        setSprite("animals/Animal-no-bg.png");
        createSprite(6,2, 50,50);
    }
    
        private final static int SPEEDVARIATION = 3;
        private final static int SPEEDCHANGECHANCE = 10;
        
        private int lastPos = 1;
        
        private int animationIndex = 7;
        private int frameCounter = 0;
        
    
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
    
    protected void animate(){
        frameCounter++;

        if (frameCounter % 5 == 0) {  
            animationIndex = (animationIndex + 1) % 3 + 6; 

            GreenfootImage currentSprite = null; 

            if (speedX > 0) {  
                currentSprite = getSpriteFrame(animationIndex, 1);
                lastPos = 1;
            } else if (speedX < 0) {  
                currentSprite = getSpriteFrame(animationIndex, 3);
                lastPos = 3;
            } else if (speedY > 0) {  
                currentSprite = getSpriteFrame(animationIndex, 2);
                lastPos = 2;
            } else if (speedY < 0) {  
                currentSprite = getSpriteFrame(animationIndex, 0);
                lastPos = 0;
            }else{
                animationIndex = 7;
                currentSprite = getSpriteFrame(7,lastPos);
            }

            if (currentSprite != null) {
                setImage(currentSprite);  
                getImage().scale(50,50);
            }
        }
    }
}
