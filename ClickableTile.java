import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClickableTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClickableTile extends Tile
{
    SimpleTimer timer;
    MouseInfo mouse;
    Color activeColor = new Color(200, 200, 200, 100);
    final int buttonCooldown = 20;
    
    Boolean active;

    public ClickableTile(int t, GreenfootImage[] tImg){
        super(t, tImg);
        active = false;
        timer = new SimpleTimer();
    }
    
    
    public ClickableTile(int t, Board b){
        this(t,b.tileImgs);
    }
    
    public void act()
    {
        //super.act();
        click();
        
    }
    
    //handles all the code you want to run if we have a click event
    void click(){
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            if(mouse.getButton()==1 && mouse.getClickCount() == 1&&mouse.getActor() == this&&timer.millisElapsed()>buttonCooldown){
              timer.mark();  
            }
            if(timer.millisElapsed() < buttonCooldown){
                img = getImage();
                if(mouse.getActor() == this){//mouse.getX()>getX()-img.getWidth()/2 && mouse.getX()<getX()+img.getWidth()/2 &&mouse.getY()>getY()-img.getHeight()/2 &&mouse.getY()<getY()+img.getHeight()/2){
                    tileType++;
                    if(tileType >= tileImgs.length){
                        tileType = 0;
                    }
                    setImage(tileImgs[tileType]);
                }
            }
            //else {
            //    getWorld().showText("", getWorld().getWidth()/2, 200);
            //}
        }
    }
}
