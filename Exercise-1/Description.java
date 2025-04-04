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
             makeImage("Περιγραφή", 
    "Το Yonko Game είναι ένα συναρπαστικό παιχνίδι στρατηγικής και"
    +"περιπέτειας, όπου στόχος \nσου είναι να συλλέξεις αντικείμενα και να τα"
    +"τοποθετήσεις σωστά μέσα στο σπίτι, για να \nφορτίσεις το Totem σου με "
    +"ενέργεια και να νικήσεις!\n"
    +"Μπορείς να μεταφέρεις μόνο 1 αντικείμενο κάθε φορά. Πρόσεχε έξω,"
    +" καθώς κυκλοφορούν \nδηλητηριώδη φίδια που μειώνουν τη ζωή σου (Water)."
    +"\nΗ ζωή σου μείωνετε καθώς περνάει ο χρόνος ανάλογα με τα αντικείμενα που έχεις συλλέξει"
    +"\nΘα συναντήσεις κοτούλες που γεννούν \nαυγά. Μπορείς να τα φας για έξτρα "
    +"πόντους, αλλά πρόσεχε γιατί τα αγαπούν και τα σκυλάκια!\n"
    +"Μέσα στο σπίτι θα βρεις food που σου δίνει ζωή, αλλά όσο φέρνεις "
    +"αντικείμενα, αυτό μειώνεται.\nΑν η ζωή σου φτάσει στο μηδέν, χάνεις.\n"
    +"ΝΙΚΑΣ αν τοποθετήσεις όλα τα αντικείμενα πριν χάσεις όλη τη ζωή σου.\n"

    +"Πόντοι:\n"
    +"1) Αυγό: +3 πόντοι, "
    +"2) Αντικείμενο: +10 πόντοι, "
    +"3) Extra πόντοι ανάλογα με τη ζωή στο τέλος\n"
    +"Παίξε έξυπνα, πρόσεχε τα φίδια και ξεκίνα την περιπέτεια τώρα!\n"
    +"Πάτησε ENTER για να ξεκινήσεις...");
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
