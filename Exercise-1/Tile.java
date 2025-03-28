import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    private final static int WIDTH = 50;
    private final static int HEIGHT = 50;
    private int typeTile;
    String image;
 
    private int countPixel = 2; 
    private GreenfootImage spriteSheet;
    private GreenfootImage currentSprite;
    private int spriteWidth = 612/(19*countPixel);
    private int spriteHeight = 576/(18*countPixel);
    private int tileSize = 32;
     
    public Tile(int width,int height, String path, String type, int theTypeTile){
        this.image = "tiles/"+ path + type;
        setImage(this.image);
        getImage().scale(width, height);
        typeTile = theTypeTile;
    }
    public Tile(String path){
        getImage().scale(WIDTH, HEIGHT);
    }
    
    public int getType(){
        return typeTile;
    }
    
    public void setImage(String img, String type){
            setImage(img + type);
    }
    
    public void setType(int type){
        typeTile = type;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    // Functions for Dynamic Sprites
    
    public void setCountPixel(int px){
        countPixel = px;
    }
    public int getCountPixel(){
        return countPixel;
    }
    
    public void setTileSize(int size){
        tileSize = size;
    }
    public void setSpriteWidthAndHeight(int width,int height,int countX,int countY){
        spriteWidth = width/(countX*countPixel);
        spriteWidth = width/(countY*countPixel);  
        spriteSheet = new GreenfootImage("sprites/Overworld.png");
    }
    public void createDynamicSprite(int column, int row, int dimension, int scaleX, int scaleY,int cutPixelX, int cutPixelY){
       
        // Δημιουργία εικόνας για το σπίτι (π.χ. 3x3 πλακίδια = 96x96 pixels)
        // create image for home (3x3 tiles = 96x96 pixels) remove 5 pixels from x & y 
        GreenfootImage houseImage = new GreenfootImage((tileSize-cutPixelX) * dimension, (tileSize-cutPixelY) * dimension);

        int startX = column; // colum
        int startY = row; // row

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
        getImage().scale(scaleX,scaleY); 
    }
    
    private static GreenfootImage tileset = new GreenfootImage("sprites/Overworld.png");
    private static final int TILE_SIZE = 16;  

    public void updateSprite(int tileX, int tileY){
 
        GreenfootImage tileImage = new GreenfootImage(TILE_SIZE, TILE_SIZE);
        
        // Αντιγράφουμε το κομμάτι από το tileset
        tileImage.drawImage(tileset, -tileX * TILE_SIZE, -tileY * TILE_SIZE);
        
        // Ορίζουμε το κομμένο tile ως εικόνα του αντικειμένου
        setImage(tileImage);
        getImage().scale(25,25);
    }
    

}
