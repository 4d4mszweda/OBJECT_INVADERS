package weapon;

import java.awt.*;

public class Laser extends Weapon{

    private boolean hit;
    private final static int highLaser = 600;
    public Laser(){
        super();
    }
    public Laser(int x, int y, int w, String u){
        super(x, y, w, highLaser, 0, "laser.png");
        setY(highLaser);
        hit = false;
    }
    @Override
    public void move(int direction) {
        //ten się nie rusza, po prostu jest
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public void draw(Graphics window) {
        window.drawImage(getImg(),getX(),getY(),getW(),getH(),null);
    }
}
