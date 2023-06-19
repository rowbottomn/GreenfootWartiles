import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClickableBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClickableBoard extends Board
{
    ClickableTile [][] tiles;
    
    
    public ClickableBoard(int[][] tInts, GreenfootImage[] tImgs){
        super(tInts,tImgs);
        
        this.tiles = new ClickableTile[numH][numH];
                
    }
       
   void loadRandom(){
        
           double tileW =tileImgs[0].getWidth();
           double tileH =tileImgs[0].getHeight();
           for(int i = 0; i < numW; i++){
               for(int j = 0;j< numH; j++){
                   this.tiles[i][j] = new ClickableTile(Greenfoot.getRandomNumber(5), tileImgs);
                   //tiles[i][j].getImage().scale(50,50);
                   game.addObject(this.tiles[i][j], (int)(((double)i+0.5)*tileW),(int)(((double)j+0.5)*tileH));
               }
           }
    }
    
    void load(int[][] tileInts){
        double tileW =tileImgs[0].getWidth();
        double tileH =tileImgs[0].getHeight();
        for(int i = 0; i < numW; i++){
           for(int j = 0;j< numH; j++){
               this.tiles[i][j] = new ClickableTile(tileInts[i][j], tileImgs);
               game.addObject(this.tiles[i][j], (int)(((double)i+0.5)*tileW),(int)(((double)j+0.5)*tileH));
           }
        }
        
    }
}
