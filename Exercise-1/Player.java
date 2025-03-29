import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int SPEED = 1;
    private int extraSpeed = 2;
    private int speedX = SPEED;
    private int speedY = SPEED;
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    private int spriteWidth = 288/12;
    private int spriteHeight = 256/8;
    private int posImageX = 1;
    private int posImageY = 2;
    private int posImageStay = 1;
    private State state;
    private Life myLife;
    private Item foundSomething;
    
    private long lastFrameTime = 0;
    private int frameDelay = 100; // Καθυστέρηση 100ms  
    
    public Player(Life life){
        spriteSheet = new GreenfootImage("players/People5.png");
        updateSprite(posImageX,posImageY);
        myLife = life;
        setLife();
        //state.getInstance().saveWater(life.getLife());
    }
    public void act()
    {       
            handleKeyPresses();
            boundedMove(); 
            lookForFood();
    }
    
   
    
    private void handleKeyPresses() {
        Tile tile = (Tile) getOneObjectAtOffset(5,5,Tile.class);
        if( tile != null && tile.getType() == 41){
            SPEED = extraSpeed;
        }else{
            SPEED = 1;
        }
            
        if(Greenfoot.isKeyDown("left")){
            handleArrowKey("left", -SPEED, 0);
        }else if(Greenfoot.isKeyDown("right")){
            handleArrowKey("right", SPEED, 0);
        }else if(Greenfoot.isKeyDown("up")){
            handleArrowKey("up", 0, -SPEED);
        }else if(Greenfoot.isKeyDown("down")){
            handleArrowKey("down", 0, SPEED);
        }else if(Greenfoot.isKeyDown("f")){
            World world = getWorld();
            if (world instanceof World1){
                if(foundSomething != null){
                    pickUpItem();
                }
                //world.addObject(new Animation(), getX()+10, getY()-25);
            }
        }else if(Greenfoot.isKeyDown("d")){
            World world = getWorld();
             if (world instanceof InsideHome){
                    
            
                    ArrayList<ItemData> items = Inventory.getInstance().getInventory();
                    if(items.size() > 0){
                        //world.addObject(new Animation(), getX()+10, getY()-25);
                        Item item = new Item(items.get(0).getCol(), items.get(0).getRow());
                        int posX = 0;
                        int posY = 0;
                        switch(posImageY){
                            case 0:
                                 posY = -25;
                                break;
                            case 1:
                                 posX = +30;
                                break;
                            case 2:
                                posY = 20;
                                break;
                            case 3:
                                posX = -30;
                                break;
                                default:break;
                        }
                        world.addObject(item, getX()+posX, getY()+posY);
                        Inventory.getInstance().useItem(item, getX()+posX, getY()+posY);
                    }
             }
        }else{
            updateAnimation("stay");
        }              
    }
    
    private void pickUpItem() {
        Item item = (Item) getOneIntersectingObject(Item.class);
        
        if (item != null && !Inventory.getInstance().hasItem(item.getCol(), item.getRow())) {
            Inventory.getInstance().addItem(item);
            getWorld().removeObject(item);
        }
    }

    private void handleArrowKey(String k, int sX, int sY) {
        if( Greenfoot.isKeyDown(k) ) {
            speedX = sX;
            speedY = sY;          
            updateAnimation(k);            
        }
    }
    
    private void boundedMove() {
        setLocation(getX()+speedX, getY()+speedY);
        if(canMove(speedX,speedY)){           
            speedX = 0;
            speedY = 0;
        }else{
            setLocation(getX()-speedX, getY()-speedY);
        }
    }
    
    private boolean canMove(int dx, int dy){
        foundSomething = null;
        int x = getX() + dx ;
        int y = getY() + dy;
        if( dy > 0 ) y += 15;
        if(dx <30 ) x -=5;
        Tile tile = (Tile) getOneObjectAtOffset(x - getX(),y- getY(),Tile.class);
        if(tile != null){
            switch(tile.getType()){
                case 3:
                case 0:
                    return false;
                case 4:
                    if(isAtHouseDoor(tile,x,y)){   
                       state.getInstance().saveWater(myLife.getLife());
                       Greenfoot.setWorld(new InsideHome(this));
                    }
                   return false;
                case 5: 
                    //Greenfoot.setWorld(new World1());
                    World currentWorld = getWorld();
                    tile.setImage("tiles/door-open", ".gif");
                    if(currentWorld.getClass() == World1.class)
                        tile.setType(7);
                    else if( currentWorld.getClass() == InsideHome.class)
                       tile.setType(6);                   
                    return false;
                case 6:
                    state.getInstance().saveWater(myLife.getLife());
                    //tile.setType(5);
                    Greenfoot.setWorld(new World1());
                    return true;
                case 7:
                    Greenfoot.setWorld(new InsideHome(this));
                    return true;
                default:
                    if(isTouching(Fountain.class)){
                       Fountain fountain = (Fountain) getOneObjectAtOffset( x+5 - getX(),y+15- getY(),Fountain.class);
                       if(fountain!= null){
                            return false; 
                       }
                    }
                    if(isTouching(Item.class)){
                        Item item = (Item) getOneObjectAtOffset(x+5- getX(),y-15 -getY() ,Item.class);
                        if(item != null){
                            World world = (World) getWorld();
                            world.addObject(new Animation(), getX()+10, getY()-25);
                            foundSomething = item;
                            return false;
                        }                           
                    }
                    return true;
            }
        }else
            return true;
    }
    
    public void updateSprite(int col, int row){
        currentSprite = new GreenfootImage(spriteWidth,spriteHeight);
        currentSprite.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        setImage(currentSprite);
        getImage().scale(50,50);
    }
    
    private void updateAnimation(String move){
        switch(move){
            case "up":
                posImageY = 0;
                break;
            case "down":
                 posImageY = 2;
                break;
            case "right":
                 posImageY = 1;
                break;
            case "left":
                 posImageY = 3;
                break;
            default:
                posImageX = posImageStay;
                break;
        }
        if(move.equals("stay")){
             updateSprite(posImageX,posImageY);
        } else if (System.currentTimeMillis() - lastFrameTime > frameDelay) {
            posImageX++;
    
            if(posImageX >= 2){ 
                posImageX = 0;   
            } 
            
            updateSprite(posImageX,posImageY);
            lastFrameTime = System.currentTimeMillis();
        }      
    }
    
    private boolean isAtHouseDoor(Tile tile, int x, int y){
       
        if(x >= 80 && x<=90  && y>150)
            return true;
        else 
            return false;
        
    }
    
    private void lookForFood(){
        
       List<Food> foods = getWorld().getObjectsAt(getX(), getY(), Food.class);
        if (!foods.isEmpty()) 
        {
            myLife.heal(10);
           getWorld().removeObject(foods.get(0));
        }
    }
    
    public void setLife(){
        myLife.setLife(State.getInstance().getWater());
    }
    public Life getLife(){
        return myLife;
    }
    
    public void getDamage(int damage){
        myLife.damage(damage);
    }
    
    public boolean hasInInventory(int col, int row){
        return Inventory.getInstance().hasItem(col,row);
    }
}
