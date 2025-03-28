/**
 * Write a description of class ItemData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemData  
{
    private int col, row;
    private String spritePath;

    public ItemData(int col, int row, String spritePath) {
        this.col = col;
        this.row = row;
        this.spritePath = spritePath;
    }

    public int getCol() { return col; }
    public int getRow() { return row; }
    public String getSpritePath() { return spritePath; }
}
