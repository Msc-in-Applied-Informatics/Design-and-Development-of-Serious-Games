import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World implements Stats
{
    private Console console;
    private GreenfootSound backgroundMusic = new GreenfootSound("17 MT11 ForestTown.mid"); 
    private final static int ROW = 24;
    private final static int COL = 32;
    private final static int SWIDTH = 1000;
    private final static int SHEIGHT = 600;
    private final static int WWIDTH = 1200;
    private final static int TWIDTH = 25;
    private final static int END_WORLD_RIGHT = 220;
    private final static int END_WORLD_LEFT = 30;
    private final static int TILEOFFSET = TWIDTH/2;
    private final static int THEIGHT = TWIDTH;
    private  Life life;
    private int counter;
    // Map
    private final static int[][] map = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,41,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,3,3,1,3,3,1,1,1,1,1,1,1,1,1,41,41,41,41,41,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,1,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,10,13,16,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,11,14,17,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,12,15,18,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,1,1,1,1,1,1,1,1,1,1,1,41,1,1,1,1,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,3,2,2,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,3,2,2,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  
    };
    public World1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(SWIDTH, SHEIGHT, 1); 
        createMap();       
        setPaintOrder(Weather.class,Paralize.class,Player.class,Animal.class,Door.class,Home.class,Fountain.class,Animation.class,Item.class,Tile.class);
        createScoreBoard();
        Player player = new Player(life);
        List<Home> list = this.getObjects(Home.class);
        if(!list.isEmpty())
            addObject(player,list.get(0).getX(), list.get(0).getY()+60);
        else
            addObject(player,getWidth()/2, getHeight()/2);
        State.getInstance().resetState();
        createAnimals();
        
        createItems();
       
        //backgroundMusic.playLoop();
    } 
    public World1(Player player){
        super(SWIDTH,SHEIGHT,1);
    }
    
    private void createMap(){
        for(int row = 0; row < ROW;row++){
            for(int col = 0; col < COL; col++){
                Actor tile = null;
                switch(map[row][col]){
                    case 41:
                        tile = new Tile(TWIDTH,THEIGHT,"road",".gif",41);
                        break;
                    case 0:
                        tile = new Limit(TWIDTH,THEIGHT,"wall",".gif",0);
                        break;
                    case 1:                        
                        tile = new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1);
                        break;
                    case 2:
                        tile = new Tile(TWIDTH,THEIGHT,"water",".gif",2);
                        break;
                    case 3: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",3), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Rocks(TWIDTH,THEIGHT,"rocks",".gif",3);
                        break;
                    case 4:
                        //addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",3), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        //Home home = new Home(TWIDTH,THEIGHT,"home-door-close",".jpg",4);
                        //addObject(home,100,100);
                        tile = new Home(TWIDTH,THEIGHT,"home-door-close",".jpg",4);
                        break;
                    case 5:
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Door(TWIDTH+20,THEIGHT+10,"door-close",".gif",5);
                        break;
                    case 10: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",10,22,9);
                        break;
                     case 11: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",11,22,10);
                        break;
                     case 12: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",12,22,11);
                        break;
                     case 13: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",13,23,9);
                        break;
                     case 14: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",14,23,10);
                        break;
                     case 15: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",15,23,11);
                        break;
                     case 16: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",16,24,9);
                        break;
                    case 17: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",17,24,10);
                        break;
                    case 18: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",1), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Fountain(TWIDTH,THEIGHT,"home-door-close",".jpg",18,24,11);
                        break;
                    default: break;
                }
                if( tile != null) 
                    addObject(tile, TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
            }
        }
    }
    
    public void act(){
        createWeather();
    }
    
    private void createWeather(){
        if (Greenfoot.getRandomNumber(10) < 9) { // 30% πιθανότητα να δημιουργηθεί σταγόνα
            int pos =  Greenfoot.getRandomNumber(getWidth());
            if(pos>22)
                addObject(new Rain(),pos, END_WORLD_LEFT);
            else{
                addObject(new Rain(),Greenfoot.getRandomNumber(20)+22, Greenfoot.getRandomNumber(101)+END_WORLD_RIGHT);
            }
        }
    }
    
    private void createAnimals(){
        Dog dog = new Dog();        
        addObject(dog,getWidth()/2, getHeight()/2);
        Chicken chicken = new Chicken();
        addObject(chicken,getWidth()/3, getHeight()/3);
        Chicken chicken2 = new Chicken();
        addObject(chicken2,getWidth()/5, getHeight()/5);
        Snake snake = new Snake();
        addObject(snake, 400,500);
              Snake snake2 = new Snake();
        addObject(snake2, 200,200);
              Snake snake3 = new Snake();
        addObject(snake3, 300,130);
              Snake snake4 = new Snake();
        addObject(snake4, 320,280);
              Snake snake5 = new Snake();
        addObject(snake5, 400,80);
    }
    
    private void createItems(){
        createItemNotCollected(0, 1, 100, 30);
        createItemNotCollected(1, 1, 700, 30);
        createItemNotCollected(2, 1, 100, 200);
        createItemNotCollected(3, 1, 700, 540);
    }
    
    private void createItemNotCollected(int col, int row, int posX, int posY){
        if (!Inventory.getInstance().hasItem(col, row)) {   
            Item item = new Item(col, row);
            addObject(item, posX, posY);
        }
    }
    
    public void lookForActiveSouls(){ };
    
    private void createScoreBoard(){
        
        console = new Console();
        addObject(console,900,400);
        life = new Life();
        
        addObject(life,920,50);
        PlayerImage icon = new PlayerImage();
        addObject(icon,820,50);
    }
    
    @Override
    public void setLife(int lvl){
        counter = lvl;
    }
}
