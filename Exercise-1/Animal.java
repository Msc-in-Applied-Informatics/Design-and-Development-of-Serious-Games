import greenfoot.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Animal. This is the base class for all animals. In addition to the standard Actor
 * methods, it provides methods to check for being at the edge of the world, as well as
 * seeing and eating other classes.
 * 
 * @author Michael Kolling
 * @version 2.0
 */
abstract public class Animal extends Actor
{
    private static final int WALKING_SPEED = 5;
    private int spriteWidth = 288/12;
    private int spriteHeight = 256/8;
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    
    protected static final int SPEED = 2;
    private static final int BOUNDARY = 40;
    protected int speedX = SPEED;
    protected int speedY = SPEED;
    
    public void setSprite(String path){
         spriteSheet = new GreenfootImage(path);
    }
    
    public void createSprite(int col, int row,int scaleX,int scaleY){
        currentSprite = new GreenfootImage(spriteWidth,spriteHeight);
        currentSprite.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        setImage(currentSprite);
        getImage().scale(scaleX,scaleY);
    }
    
    public void move()
    {
        move(WALKING_SPEED);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true if we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    
    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
    
    protected void seeSomething(){
        
    }
    
    public void act() {
        sense();
        reaction();
        boundedMove();
        animate();
    }
    
    protected void sense() {
        // No smarts
    }

    protected void reaction() {
        // No reaction
    }

    protected void boundedMove() {
        int x = getX() + speedX ;
        int y = getY() + speedY;
        if( speedY > 0 ) y += 25;
        Tile tile = (Tile) getOneObjectAtOffset(x - getX(),y- getY(),Tile.class);
        setLocation(getX()+speedX, getY()+speedY);
        if(tile!=null){
            switch(tile.getType()){
                case 0:
                case 2:
                case 3:
                case 4:
                    setLocation(getX()-speedX, getY()-speedY);
                    break;
                default:
                     if(isTouching(Fountain.class)){
                       Fountain fountain = (Fountain) getOneObjectAtOffset( x+5 - getX(),y+15- getY(),Fountain.class);
                       if(fountain!= null){
                            setLocation(getX()-speedX, getY()-speedY);
                       }
                    }
                    
                    if(isTouching(Item.class)){
                        setLocation(getX()-speedX, getY()-speedY);
                    }
                    break;
                    
            }
        }
        
        seeSomething();
        
    }
    
    protected void animate(){
        //no animate
    }
    
     public GreenfootImage getSpriteFrame(int col, int row) {
        GreenfootImage frameImage =  new GreenfootImage(spriteWidth,spriteHeight);
        frameImage.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        return frameImage;
    }
}