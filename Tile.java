import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Tile has:
 * image
 * movement cost
 * def bonus
 * attack bonus
 * income
 * resource
 * Building
 * 
 * Tile does:
 * calcIncome
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    //snow, water, road, field , desert, village, capital, fort
    int[] mv = {4, 5, 1, 2, 3};
    int [] def = {1, -1, 0, 0, 0};
    int[] att = {-1, -2, 0, 0, -1};
    int [] inc = {1, 1, 2, 3, 0};
    int tileType;
    GreenfootImage img;
    Building building;
    Game game;
    GreenfootImage [] tileImgs;
    Board board;
    
    public Tile(int t){
        tileType = t;
    }
    
    public Tile(int t, Board b){
        this(t, b.tileImgs);
    }
    
    public Tile(int t, GreenfootImage[] tImg){
        tileType = t;
        tileImgs = tImg;
        setImage(tileImgs[t]);
    }
    
    
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(game == null){
          game = (Game)getWorld(); 
          board = game.board;
          if (board != null){
              tileImgs = board.tileImgs;
          }
          setImage(tileImgs[tileType]);
                
        }
        // Add your action code here.
    }
}
