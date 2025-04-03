import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Announce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Announce extends Actor
{
    public static final float FONT_SIZE = 22.0f;
    public static final float FONT_SIZE_TITLE = 40.0f;
    public static final float FONT_SIZE_TOTAL = 35.0f;
    public static final int WIDTH = 770;
    public static final int HEIGHT = 580;
    private GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
    
    private GreenfootSound victorySound = new GreenfootSound("Victory.mid");
    private GreenfootSound defeatSound = new GreenfootSound("Defeat.mid");
    int[] score;    
    private int water;
    private long  lastUpdateTime = 0;
    private double time = 0.1;
    private int eggs = 0;
    private int totems = 0;
    private int scoreTime = 10;
    private int life = 0;
    private int totalScore = 26*3 + 4*10;
    
    private boolean firstLine = false;
    private boolean secondLine = false;
    private boolean thirdLine = false;
    
    private String type;
    
    
    public Announce(String type){
        score = State.getInstance().getScore();
        water = State.getInstance().getWater();
        this.type = type;
        makeImage("", "","","","");
    }
    
     private void makeImage(String title, String prefix1, String prefix2, String prefix3,String prefix4)
    {
      
        image.setTransparency(250);
        image.setColor(new Color(200,205,205, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
       
        
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE_TITLE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 300, 240);
        
        Font font2 = image.getFont();
        font2 = font.deriveFont(FONT_SIZE);
        image.setFont(font2);
        image.drawString(prefix1, 325, 300);
        if(firstLine){
            image.drawLine(270, 316, 500, 316);
        }
        Font font3 = image.getFont();
        font3 = font.deriveFont(FONT_SIZE);
        image.setFont(font3);
        image.drawString(prefix2, 310, 350);
        
        if(secondLine){
            image.drawLine(270, 370, 500, 370);
            
        }
        
        Font font4 = image.getFont();
        font4 = font.deriveFont(FONT_SIZE);
        image.setFont(font4);
        image.drawString(prefix3, 300, 400);
        
        if(thirdLine){
            image.drawLine(270, 420, 500, 420);
            image.setColor(Color.RED); 
        }
        
        Font font5 = image.getFont();
        font5 = font.deriveFont(FONT_SIZE_TOTAL);
        image.setFont(font5);
        image.drawString(prefix4, 320, 470);
        
        GreenfootImage defeat = new GreenfootImage("Game Over.png");
        defeat.scale(480,150);
        image.drawImage(defeat, 150, 50);
        
        setImage(image);
        
       
    }
    
    
    
    public void act(){
        updatePointView(); 
    }
    
    private void updatePointView(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime  >= time*1000) {
            if(scoreTime == 0){                    
                if(eggs < score[0]){
                    eggs++;
                    makeDraw("Eggs:  "+ eggs +" x 3\n","","","");                
                }else if(totems < score[1]){
                    if(firstLine){
                        totems++;
                        makeDraw("Eggs:  "+ eggs +" x 3\n","Totems:  " + totems + " x 10","","");
                    }else{
                        firstLine = true;
                    }
                }else if(life < water){
                    if(secondLine){
                        life++;
                        makeDraw("Eggs:  "+ eggs +" x 3\n","Totems:  " + totems + " x 10","Health Bar: " +life + " ❤","");
                    }else
                        secondLine = true;
                    
                }else{
                    if(thirdLine){
                         makeDraw("Eggs:  "+ eggs +" x 3\n","Totems:  " + totems + " x 10", "Health Bar: " +life + " ❤","Total: "+ (eggs*3 + totems*10 + getTotalLife(life)));
                    }else
                        thirdLine = true;
                }
            }else{
                scoreTime--;
                if(scoreTime == 5){
                    if(type == "LOSS"){
                        defeatSound.play();
                    }else{
                        victorySound.play();
                    }
                  makeDraw("","","","");
                  
                }
            }
            lastUpdateTime = currentTime;
        }
    }
    
    private void makeDraw(String text, String text2, String text3, String text4){
        image.clear();
        makeImage("YOU "+ this.type,text,text2, text3, text4);
    }
    
    private int getTotalLife(int life){
        if(life>=60){
            return 100;
        }else if(life>=45){
            return 80;
        }else if(life>=30){
            return 60;
        }else if(life>=15){
            return 40;
        }else if(life>=1){
            return 20;
        }else
            return 0;
    }
    
    public void Victory(){
        
    }
    
    public void Defeat(){
       
    }
}
