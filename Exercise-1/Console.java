import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Console here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Console extends Actor
{
    private String text = ""; 
    private int width = 200;  
    private int height = 800; 
    
    public void act()
    {
       
    }
    public Console() {
        updateImage();
    }
    
     public void log(String message) {
        text += message + "\n"; // Προσθέτει νέο μήνυμα
        updateImage();
    }
    
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.BLACK);
        img.fillRect(0, 0, width, height); 
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", 16));
        img.drawString(text, 10, 20);
        setImage(img);
    }
}
