import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

/**
 * Write a description of class MapEditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapEditor extends World
{
    Game game;
    ClickableBoard board;
    
    //file stuff
    FileManager fm;
    ArrayManager am;
    
    /**
     * Constructor for objects of class MapEditor.
     * 
     */
    public MapEditor(Game g, GreenfootImage[] tImgs)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 512, 1);
        game = g;
        am = new ArrayManager();
        fm = new FileManager();
        //board = new Board(game.board.numW,game.board.numH, true);
        int[][] tileInts = am.fillArrayWithZeroes(game.board.numW, game.board.numH);
        am.fillArrayWithData("input.txt", tileInts);
        board = new ClickableBoard(tileInts, tImgs);
        addObject(board, -50,-50);
        
    }
    
 
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            String temp = am.arrayToString(board.tileInts);
            System.out.println(temp);
            fm.writeAll("output.txt",temp);
            Greenfoot.setWorld(game);
        }
    }
}

