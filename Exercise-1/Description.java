import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Description here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Description extends Actor
{
    public static final float FONT_SIZE = 13.0f;
    public static final float FONT_SIZE_TITLE = 22.0f;
    public static final int WIDTH = 580;
    public static final int HEIGHT = 380;
    
    public Description(){
        makeImage("Description", 
            "YONKO GAME is an exciting strategy and adventure game where your goal is to collect items \n and place them correctly inside the house to charge your Totem with energy and win!\n"
            + "You can carry only 1 item at a time. Be careful outside, as there are poisonous snakes that \nreduce your life (Water).\n"
            + "Your life decreases over time, depending on the items you have collected.\n"
            + "You will encounter chickens that lay eggs. You can eat them for extra points, but be careful \nbecause the dogs love them too!"
            + " Inside the house, you will find food that restores your life, \nbut as you bring in items, it decreases.\n"
            + "If your life reaches zero, you lose.\n"
            + "YOU WIN if you place all items inside the house before losing all your life.\n"
        
            + "Points:\n"
            + "1) Egg: +3 points, "
            + "2) Item: +10 points, "
            + "3) Extra points depending on remaining life at the end.\n"
            + "Play smart, watch out for the snakes, and start your adventure now!\n"
            + "Press ENTER to begin..."
            + "\n** Press 'F' to pick up, and 'D' to place the item from your inventory.");
    }
    
     private void makeImage(String title, String prefix)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(200,205,205, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE_TITLE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 250, 30);
        Font font2 = image.getFont();
        font2 = font.deriveFont(FONT_SIZE);
        image.setFont(font2);
        image.drawString(prefix, 20, 50);
        GreenfootImage playButton = new GreenfootImage("play-button.png");
        playButton.scale(180,60);
        image.drawImage(playButton, 200, 310);
        setImage(image);
    }
}
