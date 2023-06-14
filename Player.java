import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * PLayer has:
 * A list of units
 * A list of tiles it controls
 * Money to spend
 * Tile location
 * 
 * PLayer does:
 * take a turn
 * buy units
 * fortify tile
 * move units
 * attack with units
 * calcIncome
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int baseX;
    int baseY;//y location of home base
    ArrayList<Unit> units = new ArrayList<Unit>();
    ArrayList<Tile> tiles = new ArrayList<Tile>();
    Game game;
    
    public Player(Game game, int x, int y){
        this.game = game;
        baseX = x;
        baseY = y;
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
