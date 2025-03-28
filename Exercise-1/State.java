/**
 * Write a description of class Saver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class State  
{
    private static State instance;
    private int savedScore = 0;
    private int savedPositionX = 0;
    private int savedPositionY = 0;
    private int waterIndex = 70;

    private State() {
        // Ιδιωτικός constructor για Singleton pattern
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    public void saveState(int score, int posX, int posY) {
        this.savedScore = score;
        this.savedPositionX = posX;
        this.savedPositionY = posY;
    }

    public int getSavedScore() {
        return savedScore;
    }

    public int getSavedPositionX() {
        return savedPositionX;
    }

    public int getSavedPositionY() {
        return savedPositionY;
    }

    public void resetState() {
        waterIndex = 70;
        savedScore = 0;
        savedPositionX = 0;
        savedPositionY = 0;
    }
    
    public void saveWater(int pos){
        waterIndex = pos;
    }
    public int getWater(){
        return waterIndex;
    }
}