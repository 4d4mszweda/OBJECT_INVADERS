package weapon;

import java.awt.*;

public class Blaster extends Weapon{
    private boolean goUp;
    public Blaster()
    {
        super();
    }
    public Blaster(int x, int y, int w, int h, int speed, String u)
    {
        super(x, y, w, h, speed, "shoot.png");
        setY(600);
        goUp = false;
    }
    @Override
    public void move(int direction) {
        if(getY()<0){
            goUp=false;
            setY(600);
        }

        if(goUp)
            setY(getY()-getSpeed());
    }
    @Override
    public void draw(Graphics window) {
        window.drawImage(getImg(),getX(),getY(),getW(),getH(),null);
    }

//    public void setLeftRight(int d){
////        if(d==37){
////            setMoveLeft(true);
////        }
////        if(d==39){
////            setMoveRight(true);
////        }
//    }
//    public void stop(){
////        setMoveLeft(false);
////        setMoveRight(false);
//
//    }

    public boolean getGoUp() {
        return goUp;
    }

    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }
}
