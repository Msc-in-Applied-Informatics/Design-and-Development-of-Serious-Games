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
         makeImage("Περιγραφή", "Το Yonko Game είναι ένα συναρπαστικό παιχνίδι στρατηγικής και περιπέτειας, όπου \nο στόχος σου είναι να φυτέψεις όσο το δυνατόν περισσότερα δέντρα και να \nτα προστατέψεις από διάφορους κινδύνους.\n"
         +"Στην πορεία, θα πρέπει να φροντίσεις για την ανάπτυξη των δέντρων σου,\nπροστατεύοντάς τα από ζουζούνια και άλλα εχθρικά στοιχεία που απειλούν την \nανάπτυξή τους."
         +"Για να φυτέψεις τα δέντρα, θα χρειαστείς να βρεις τα κατάλληλα \nσυστατικά, όπως σπόρους, λιπάσματα και νερό για να τα βοηθήσεις να μεγαλώσουν.\n"
         +"Κάθε δέντρο που φυτεύεις έχει διαφορετικό μέγεθος, και ανάλογα με το μέγεθος του \nδέντρου σου κερδίζεις πόντους: \n1) Μικρό δέντρο: 10 πόντοι, 2) Μεσαίο δέντρο: 50 πόντοι, 3) Μεγάλο δέντρο: 100 πόντοι\n"
         +"\nΕπιπλέον, μπορείς να χρησιμοποιήσεις διάφορα εργαλεία που θα βάλεις στην τσάντα \nσου για να αντιμετωπίσεις τις προκλήσεις που θα εμφανιστούν. Ωστόσο, πρόσεξε \nγιατί τα" 
         +" ζουζούνια και άλλα εμπόδια μπορούν να σε καταδιώκουν, κάνοντάς το παιχνίδι ακόμα \nπιο έντονο και δύσκολο. Για να ξεκινήσεις την περιπέτεια σου, πάτησε ENTER και ρίξου \nστη ΔΡΑΣΗ!");
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
