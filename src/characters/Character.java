package characters;
import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

abstract class Character {
    private int x;
    private int y;
    private int speed;

    private int h;
    private  int w;

    private Image img;

    private boolean moveLeft = false;
    private boolean moveRight = false;

    Character(){}
    public Character(int x, int y, int w, int h, int speed, String u){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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

    public String toString()
    {
        return getX() + " " + getY() + " " + getW() + " " + getH() + " " + getSpeed();
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSpeed() {
        return speed;
    }
    public Image getImg() {
        return img;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public boolean getMoveLeft() {
        return moveLeft;
    }

    public boolean getMoveRight() {
        return moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
}
