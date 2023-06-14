import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Board has:
 * has an 2D array of tiles
 * 
 * 
 * Board does:
 * resets itself
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends Actor
{
    Tile[][] tiles;
    int [][] tileInts;
    int numW;
    int numH;
    World game;
    GreenfootImage[] tileImgs;
    
    public Board(int w, int h, GreenfootImage[] tImgs){
        numW = w;
        numH = h;
        tileImgs = tImgs;
        tiles = new Tile[numW][numH];
        
    }
    
    public Board(int[][] tInts, GreenfootImage[] tImgs){
        tileInts = tInts;
        numW = tileInts.length;
        numH = tileInts[0].length;
        tileImgs = tImgs;
        
        tiles = new Tile[numH][numH];
                
    }
    
    
    /**
     * Act - do whatever the Board wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (game == null){
           game = getWorld(); 
           if(tileInts == null){
               loadRandom();
            }
            else {
                load(tileInts);
            }
        }
    }
    
    void loadRandom(){
        
           double tileW =tileImgs[0].getWidth();
           double tileH =tileImgs[0].getHeight();
           for(int i = 0; i < numW; i++){
               for(int j = 0;j< numH; j++){
                   tiles[i][j] = new Tile(Greenfoot.getRandomNumber(5));
                   //tiles[i][j].getImage().scale(50,50);
                   game.addObject(tiles[i][j], (int)(((double)i+0.5)*tileW),(int)(((double)j+0.5)*tileH));
               }
           }
    }
    
    void load(int[][] tileInts){
        double tileW =tileImgs[0].getWidth();
        double tileH =tileImgs[0].getHeight();
        for(int i = 0; i < numW; i++){
           for(int j = 0;j< numH; j++){
               tiles[i][j] = new Tile(tileInts[i][j]);
               game.addObject(tiles[i][j], (int)(((double)i+0.5)*tileW),(int)(((double)j+0.5)*tileH));
           }
        }
        
    }
}
