import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    private GreenfootImage[] image = new GreenfootImage[71];
    private int index = 70;
    private long  lastUpdateTime = 0;
    private GreenfootImage currentImage;
    private GreenfootImage player;
    private boolean heal = false;
    
    public Life(){
        for(int i = 0 ; i <71;i++){
            image[i] = new GreenfootImage("/water/full/WaterMeter2_"+ i +".png");
        }
        currentImage =image[index];
        currentImage.scale(150, 50);
        setImage(currentImage);
    }

    public void act()
    {
       long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime  >= 1000 ) {
            if(heal && index < 70 )
                index++;
            else if(index>0)
                index--;
                
            lastUpdateTime = currentTime;
            updateDisplay(index);
        }
        
    }
    
     private void updateDisplay(int pos) {
        currentImage = image[pos];
        currentImage.scale(150,50);
        setImage(currentImage);
    }
    
    public int getLife(){
        return index;
    }
    
    public void setLife(int life){
        index = life;
    }
    
    public void autoHeal(){
        heal = true;
    }
    public void heal(int life){
        if(index + life <70){
            index += life;
        }else{
            index = 70;
        }
    }
    
    public void damage(int damage){
        if((index-damage)>0)
            index = index - damage;
        else 
            index = 0;
    }
    
    public void stopHeal(){
        heal = false;
    }
    
}
