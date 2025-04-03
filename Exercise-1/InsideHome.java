import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class InsideHome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsideHome extends World implements Stats
{
    private Console console;
    private Counter scoreCounter;
    private Counter scoreCounter2;
    private Counter totalScore;
    Life mylife;
    private int counter;
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
    private int counterItem = 0;
    private Totem totem = new Totem();
    private final static int[][] map = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,3,41,41,41,41,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,3,41,41,41,41,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,20,20,1,1,1,1,1,1,3,1,1,41,41,3,1,1,1,1,1,1,1,1,1,1,20,20,1,1,0},
        {0,1,1,20,20,1,1,1,1,1,1,3,1,1,41,41,3,1,1,1,1,1,1,1,1,1,1,20,20,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,41,41,41,41,1,1,1,1,1,1,1,1,41,41,1,1,1,1,1,1,1,1,1,1,41,41,41,41,1,0},
        {0,1,41,1,1,41,1,1,1,1,1,1,1,1,41,41,1,1,1,1,1,1,1,1,1,1,41,1,1,41,1,0},
        {0,1,41,1,1,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,1,1,41,1,0},
        {0,1,41,1,1,41,1,1,1,1,1,41,1,1,1,1,1,1,1,41,1,1,1,1,1,1,41,1,1,41,1,0},
        {0,1,41,41,41,41,1,1,1,1,1,41,1,3,3,3,3,3,1,41,1,1,1,1,1,1,41,41,41,41,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,41,1,3,1,1,1,3,1,41,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,3,3,3,3,3,3,3,3,1,1,41,1,3,1,1,1,3,1,41,1,1,3,3,3,3,3,3,3,3,3,0},
        {0,1,1,1,1,1,1,1,1,1,1,41,1,3,1,1,1,3,1,41,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,41,41,41,41,1,1,1,1,1,41,1,3,3,3,3,3,1,41,1,1,1,1,1,1,41,41,41,41,1,0},
        {0,1,41,1,1,41,1,1,1,1,1,41,1,1,1,1,1,1,1,41,1,1,1,1,1,1,41,1,1,41,1,0},
        {0,1,41,1,1,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,1,1,41,1,0},
        {0,1,41,1,1,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,1,1,41,1,0},
        {0,1,41,41,41,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,20,20,1,1,0},
        {0,1,1,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,20,20,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  
    };
    public InsideHome(Player player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(SWIDTH, SHEIGHT, 1); 
        createMap();       
        setPaintOrder(Announce.class,Totem.class,Animation.class,Attention.class, Item.class,Player.class,Home.class,Food.class,Tile.class);
        List<Door> list = this.getObjects(Door.class);
        if(!list.isEmpty())
            addObject(player,list.get(0).getX(), list.get(0).getY()+60);
        //addObject(player,getWidth()/2, getHeight()/2);
        createScoreBoard(player);
        //State.getInstance().resetState();
        
        createFood();      
       
        player.setLife();
        
        createItems();
        
        //Totem
        createTotem(); 
        
    }
    
    private void createMap(){
        for(int row = 0; row < ROW;row++){
            for(int col = 0; col < COL; col++){
                Actor tile = null;
                switch(map[row][col]){
                    case 0:
                        tile = new Limit(TWIDTH,THEIGHT,"wall",".gif",0);
                        break;
                    case 1:                        
                        tile = new Tile(TWIDTH,THEIGHT,"room_floor_rock",".gif",1);
                        break;
                    case 2:
                        tile = new Tile(TWIDTH,THEIGHT,"water",".gif",2);
                        break;
                    case 3: 
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",3), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new Rocks(TWIDTH,THEIGHT,"close-box",".gif",3);
                        break;
                    case 5:
                        tile = new Door(TWIDTH+20,THEIGHT,"door-close",".gif",5);
                        break;
                    case 20:
                        addObject(new Tile(TWIDTH,THEIGHT,"free-tile",".gif",20), TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
                        tile = new ItemPlace(TWIDTH, THEIGHT, "room_floor_1", ".gif",20);
                        break;
                    case 41:
                        tile = new Tile(TWIDTH,THEIGHT,"road",".gif",41);
                        break;
                    default: break;
                }
                if( tile != null) 
                    addObject(tile, TILEOFFSET + col* TWIDTH,TILEOFFSET +row * THEIGHT);
            }
        }
    }
    
    private void createScoreBoard(Player player){
        
        console = new Console();
        addObject(console,900,400);
        mylife = player.getLife();
        //mylife.autoHeal();
        addObject(mylife,920,50);
        PlayerImage icon = new PlayerImage();
        addObject(icon,820,50); 
        
        addObject(new Egg(40),820, 100);
        addObject(new X(20), 850, 100);
        scoreCounter = new Counter();
        addObject(scoreCounter, 910, 100);
        
        Item item = new Item(4,2);
        addObject(item,822, 140);
        addObject(new X(20), 850, 150);
        
        scoreCounter2 = new Counter();
        addObject(scoreCounter2, 910, 150);
        
        addObject(new EqualSymbol(40),835,200);
        totalScore = new Counter();
        addObject(totalScore,910, 200);
    }
    
    private void createFood(){
       int counter = Inventory.getInstance().getInsideItems().size();
        Food food1 = new Food(3,6);       
        Food food2 = new Food(3,6);       
        Food food3 = new Food(3,6);       
        Food food4 = new Food(3,6);
       
       if(counter == 0){
           addObject(food1,700,200);
           addObject(food2,700,400);
           addObject(food3,100,400);
           addObject(food4,100,200);
       }else if(counter == 1){
           addObject(food1,700,200);
           addObject(food2,700,400);
           addObject(food3,100,400);
       }else if (counter == 2){
            addObject(food1,700,200);
            addObject(food3,100,400);
       }else {
           addObject(food1,700,200);
       }
    }
    
    private void createItems(){
        ArrayList<ItemData> items = Inventory.getInstance().getInsideItems();
        for(ItemData item: items){
            Item obj = new Item(item.getCol(),item.getRow());
            addObject(obj,item.getPosX(),item.getPosY());   
        }
    }   
    
    private void createTotem(){        
        addObject(totem, getWidth()/3 + 55,getHeight()/2);
    }
    
    @Override
    public void setLife(int lvl){
        counter = lvl;
    }
    @Override
    public void setEggsPoints(int eggs){
        scoreCounter.setValue(eggs);
    }
    @Override
    public void setItemPoints(int items){
        scoreCounter2.setValue(items);
    }
    @Override
    public void setPoints(){
        int eggsPoints = scoreCounter.getValue() * 3;
        int itemPoints = scoreCounter2.getValue() * 10;
        totalScore.setValue( eggsPoints + itemPoints);
    }
}
