import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Tile
{
   private int countPixel = 2; 
   private GreenfootImage spriteSheet;
   private GreenfootImage currentSprite;
   private int spriteWidth = 612/(19*countPixel);
   private int spriteHeight = 576/(18*countPixel);
   public Home(int width,int height, String path, String type, int theTypeTile){
       super(width,height,path,type,theTypeTile);
       spriteSheet = new GreenfootImage("sprites/Overworld.png");
       createHome();
   }
    
 
    public void act()
    {  
        if(getY() >getWorld().getHeight() /2)
            getWorld().setPaintOrder(Weather.class,Animation.class,Door.class,Paralize.class,Player.class,Animal.class,Home.class,Fountain.class,Item.class, Tile.class);
        else
            getWorld().setPaintOrder(Weather.class,Animation.class,Door.class,Home.class,Paralize.class,Player.class,Animal.class,Fountain.class,Item.class, Tile.class);
    }
    
    public void updateSprite(int col, int row){
        currentSprite = new GreenfootImage(spriteWidth,spriteHeight);
        currentSprite.drawImage(spriteSheet,-col*spriteWidth,-row*spriteHeight);
        setImage(currentSprite);
        getImage().scale(50,50);
    }
    
    private void createHome(){
         int tileSize = 32; // Μέγεθος κάθε πλακιδίου
       
        // Δημιουργία εικόνας για το σπίτι (π.χ. 3x3 πλακίδια = 96x96 pixels)
        // create image for home (3x3 tiles = 96x96 pixels) remove 5 pixels from x & y 
        GreenfootImage houseImage = new GreenfootImage((tileSize-5) * 3, (tileSize-5) * 3);

        int startX = 3; // colum
        int startY = 0; // row

        // Create home
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                // calculate position from sprite sheet
                int sx = (startX + x) * tileSize;
                int sy = (startY + y) * tileSize;
                
                // cut tile
                GreenfootImage tile = new GreenfootImage(tileSize, tileSize);
                tile.drawImage(spriteSheet, -sx, -sy);
                
                // add image
                houseImage.drawImage(tile, x * tileSize, y * tileSize);
            }
        }
        setImage(houseImage);
        getImage().scale(120,100);
    }
}
