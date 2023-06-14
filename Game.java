import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game has:
 * Current turn
 * Array of players
 * Board
 * MapEditor
 * 
 * Game does:
 * Detect game over
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    GreenfootImage[] tileImgs = new GreenfootImage[9];
    Board board;
    Player[] players = new Player[2];
    Color[] playerColors = new Color[2];
    
    MapEditor mapEditor;
    FileManager fm;
    ArrayManager am;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 512, 1);
        //load images
        tileImgs[0] = new GreenfootImage("snow.jpg");
        tileImgs[1] = new GreenfootImage("water.jpg");
        tileImgs[2] = new GreenfootImage("road.jpg");
        tileImgs[3] = new GreenfootImage("field.jpg");
        tileImgs[4] = new GreenfootImage("desert.jpg");
        tileImgs[5] = new GreenfootImage("road.png");
        tileImgs[6] = new GreenfootImage("road2.png");
        tileImgs[7] = new GreenfootImage("road3.png");
        tileImgs[8] = new GreenfootImage("road4.png");
        //make fileManager to read in map files
        fm = new FileManager();
        am = new ArrayManager();
        
        //make board
        board = new Board(8, 8, tileImgs);
        addObject(board, -50,-50);
        
        //resize images
        int tileW = getWidth()/board.numW;
        int tileH = getHeight()/board.numH;
        
        for(int i = 0;i < tileImgs.length;i++){
            tileImgs[i].scale(tileW, tileH);
        }
        
        mapEditor = new MapEditor(this, tileImgs);
        Greenfoot.setWorld(mapEditor);
        //fm.read("output.txt");
        int[][] tileInts = new int[8][8];
        am.fillArrayWithData("output.txt", tileInts);
        board = new Board(tileInts, tileImgs);
        //make the players and add them to the world
        players[0] = new Player(this, 4, 0);
        players[1] = new Player(this, board.numW-3, board.numH-3);
        playerColors[0] = new Color(255,0,0,50);
        playerColors[1] = new Color(0,0,255,50);
        //set the hq for the players
        GreenfootImage img0 = players[0].getImage();
        img0.scale(tileW, tileH);
        img0.setColor(playerColors[0]);
        img0.fillRect(0,0, img0.getWidth(), img0.getHeight() );
        
        GreenfootImage img1 = players[1].getImage();
        img1.scale(tileW, tileH);
        img1.setColor(playerColors[1]);
        img1.fillRect(0,0, img1.getWidth(), img1.getHeight() );
        addObject(players[0], (int)((players[0].baseX + 0.5)*(double)tileW), (int)((players[0].baseY + 0.5)*(double)tileH));
        addObject(players[1], (int)((players[1].baseX + 0.5)*(double)tileW), (int)((players[1].baseY + 0.5)*(double)tileH));
        setPaintOrder(Unit.class, Building.class,Player.class, Tile.class);
    }
}
