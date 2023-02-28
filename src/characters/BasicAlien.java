package characters;

import java.awt.*;

public class BasicAlien extends Character{
    private boolean isVisible;

    BasicAlien(){}
    public BasicAlien(int x, int y, int w, int h, int speed, String u){
        super(x, y, w, h, speed, u);
        setMoveRight(true);
        isVisible = true;
    }
    public  void move(int direction){
        if(getMoveLeft())
            setX(getX()-getSpeed());

        if(getMoveRight())
            setX(getX()+getSpeed());
    }
    public void draw(Graphics window){
        window.drawImage(getImg(),getX(),getY(),null);
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean getVisible() {
        return isVisible;
    }

}
