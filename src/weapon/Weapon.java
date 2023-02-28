package weapon;
import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public abstract class Weapon {
    private int x;
    private int y;
    private int h;
    private int w;
    private int speed;
    private Image img;
    private boolean moveLeft = false;
    private boolean moveRight = false;

    Weapon(){}
    public Weapon(int x, int y, int w, int h, int speed, String u){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.speed = speed;

        try
        {
            URL url = getClass().getResource(u);
            img = ImageIO.read(url);
        }
        catch(Exception e)
        {
            System.out.println("img blank");
        }
    }

    public abstract void move(int direction);
    public abstract void draw(Graphics window);
    public int getW() {
        return w;
    }

    public Image getImg() {
        return img;
    }

    public int getSpeed() {
        return speed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public boolean isMoveRight() {
        return moveRight;
    }
}
