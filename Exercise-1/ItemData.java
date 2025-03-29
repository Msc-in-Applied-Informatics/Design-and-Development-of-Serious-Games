/**
 * Write a description of class ItemData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemData  
{
    private int col, row, posX, posY;
    private String spritePath;

    public ItemData(int col, int row, String spritePath, int posX, int posY) {
        this.col = col;
        this.row = row;
        this.spritePath = spritePath;
        this.posX = posX;
        this.posY = posY;
    }

    public int getCol() { return col; }
    public int getRow() { return row; }
    public String getSpritePath() { return spritePath; }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
}
