/**
 * Write a description of class insideItemData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsideItemData extends ItemData 
{
    private int posX;
    private int posY;
    
    public InsideItemData(ItemData data,int posX,int posY) {
       super(data.getCol(),data.getRow(), data.getSpritePath());
       this.posX = posX;
       this.posY = posY;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
