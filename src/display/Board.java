package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import characters.*;
import weapon.Blaster;

public class Board extends JPanel implements Runnable, MouseListener, KeyListener {
    public final static int BOARD_WIDTH = 600;
    public final static int BOARD_HEIGHT = 600;
    private BasicAlien[][] alien1;
    private Player player;
    private Blaster shoot;
    private AlienBoss boss;
    private Thread animator;
    private boolean gameOn = false;
    private boolean lose = false;


    public Board(Dimension d) {

        player = new Player(200, 500, 57, 35, 5, "player.png");
        shoot = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        alien1 = new BasicAlien[3][10];
        int x = 10;
        int y = 10;
        for (int r = 0; r < alien1.length; r++) {
            for (int c = 0; c < alien1[0].length; c++) {
                alien1[r][c] = new BasicAlien(x, y, 30, 20, 5, "alien.png");
                x += 35;
            }
            x = 10;
            y += 25;
        }

        setSize(d);
        setPreferredSize(d);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        if (animator == null) {
            animator = new Thread(this);
            animator.start();
        }
        setDoubleBuffered(true);
    }

    public void reset(){
        gameOn = false;
        player = new Player(200, 500, 57, 35, 5, "player.png");
        shoot = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        alien1 = new BasicAlien[3][10];
        int x = 10;
        int y = 10;
        for (int r = 0; r < alien1.length; r++) {
            for (int c = 0; c < alien1[0].length; c++) {
                alien1[r][c] = new BasicAlien(x, y, 30, 20, 5, "alien.png");
                x += 35;
            }
            x = 10;
            y += 25;
        }
    }

    public void reset(int bossLvl){
        gameOn = false;
        player = new Player(200, 500, 57, 35, 5, "player.png");
        shoot = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        boss = new AlienBoss(200, 200, 50, 50, 5 + bossLvl, "boss.png");
    }

    public void reset(int bossLvl, int countA){
        gameOn = false;
        player = new Player(200, 500, 57, 35, 5, "player.png");
        shoot = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        boss = new AlienBoss(200, 200, 50, 50, 5 + bossLvl, "boss.png");
        int x = 10;
        countA %= 11;
        for(int i = 0;i<countA;i++){
            alien1[0][i] = new BasicAlien(x, 10, 30, 20, 5, "alien.png");
            x += 35;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = getSize();

        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, d.width, d.height);
        if(gameOn) {
            moveAliens();
            player.move(0);
            shoot.move(0);
        }
        else{
            g2.setColor(Color.black);
            g.drawString("Naciśnij S, aby rozpocząć", 200, 200);
            if(win()){
                g.drawString("Wygrales", 200, 300);
            }
            else if(lose == true){
                g.drawString("Przegrales", 200, 300);
            }
        }
        shoot.draw(g2);
        player.draw(g2);
        hitDetect();

        for(int r = 0; r < alien1.length; r++) {
            for (int c = 0; c < alien1[0].length; c++) {
                if (alien1[r][c].getVisible())
                    alien1[r][c].draw(g2);
            }
        }
    }


    public void hitDetect() {
        for (int r = 0; r < alien1.length; r++) {
            for (int c = 0; c < alien1[0].length; c++) {
                if (alien1[r][c].getVisible() && shoot.getX() + shoot.getW() >= alien1[r][c].getX() &&
                        shoot.getX() <= alien1[r][c].getX() + alien1[r][c].getW() &&
                        shoot.getY() + shoot.getH() >= (alien1[r][c].getY()) &&
                        shoot.getY() <= alien1[r][c].getY() + alien1[r][c].getH()) {

                                    alien1[r][c].setVisible(false);
                                    shoot.setX(-30);
                }
            }
        }
    }

    public void moveAliens() {
            for (int r = 0; r < alien1.length; r++) {
                for (int c = 0; c < alien1[0].length; c++) {
                    if (alien1[r][c].getMoveLeft()) {
                        alien1[r][c].setX(alien1[r][c].getX() - alien1[r][c].getSpeed());
                    }
                    if (alien1[r][c].getMoveRight()) {
                        alien1[r][c].setX(alien1[r][c].getX() + alien1[r][c].getSpeed());
                    }
                }
            }

            for (int r = 0; r < alien1.length; r++) {
                for (int c = 0; c < alien1[0].length; c++) {

                    if (alien1[r][c].getX() > 600) {
                        moveLeftRight(1);
                        break;
                    }

                    if (alien1[r][c].getX() < 0) {
                        moveLeftRight(2);
                        break;
                    }
                }
            }

    }

    public void moveLeftRight(int d) {
        for (int r = 0; r < alien1.length; r++) {
            for (int c = 0; c < alien1[0].length; c++) {
                if (d == 1) {
                    alien1[r][c].setMoveLeft(true);
                    alien1[r][c].setMoveRight(false);
                } else {
                    alien1[r][c].setMoveLeft(false);
                    alien1[r][c].setMoveRight(true);
                }

                alien1[r][c].setY(alien1[r][c].getY() + 10);
                if(win()){
                    gameOn=false;
                }
                if(alien1[r][c].getY()>500){
                    lose = true;
                    gameOn = false;
                }
            }
        }
    }

    public boolean win(){
        for (int r = 0; r < alien1.length; r++){
            for(int c = 0; c < alien1[0].length; c++){
                if(alien1[r][c].getVisible()){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if(k==83){
            reset();
            gameOn=true;
        }
        player.setLeftRight(k);
        if(k==32)  {
            shoot.setGoUp(true);
            shoot.setX(player.getX() + (player.getW()/2));
            shoot.setY(player.getY() );
        }

    }

    public Blaster getShoot() {
        return shoot;
    }

    public AlienBoss getBoss() {
        return boss;
    }

    public Player getPlayer() {
        return player;
    }

    public BasicAlien[][] getAlien1() {
        return alien1;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        player.stop();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int animationDelay = 37;
        long time = System.currentTimeMillis();
        while(true){
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0,time - System.currentTimeMillis()));
            }
            catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
    }
}
