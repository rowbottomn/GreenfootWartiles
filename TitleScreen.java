import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    World game;
    public int selection = 0;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen(Game g)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("Title", getWidth()/2, (int)((double)getHeight()*0.2));
        showText("Press space to load the default map", getWidth()/2, (int)((double)getHeight()*0.5));
        showText("Press m to go to the map editor", getWidth()/2, (int)((double)getHeight()*0.7));
        game = g;
    }
    
    public void act(){
        
        if(Greenfoot.isKeyDown("space")){
           selection = 1; 
        }
        if(Greenfoot.isKeyDown("m")){
           selection = 2; 
        }
        if(selection != 0){
            Greenfoot.setWorld(game);
        }
    }
    
}
