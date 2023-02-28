package characters;
import java.awt.*;

public class Player extends Character {

    public Player(int x, int y, int w, int h, int speed, String u){
        super(x,y, w, h, speed, "player.png");
    }
    @Override
    public void move(int direction) {
        if(getMoveLeft())
            setX(getX()-getSpeed());
        if(getMoveRight()){
            setX(getX()+getSpeed());
        }
    }
    @Override
    public void draw(Graphics window) {
        window.drawImage(getImg(),getX(),getY(),getW(),getH(),null);
    }
    public void setLeftRight(int d){
        if(d==37){
            setMoveLeft(true);
        }

        if(d==39){
            setMoveRight(true);
        }
    }
    public void stop(){
        setMoveLeft(false);
        setMoveRight(false);

    }
}
