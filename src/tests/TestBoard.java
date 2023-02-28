package tests;
import characters.AlienBoss;
import characters.BasicAlien;
import display.Board;
import org.junit.Test;
import org.junit.Assert;
import weapon.Blaster;
import javax.swing.*;
import java.awt.*;


public class TestBoard {
    Dimension b = new Dimension(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
    Board a = new Board(b);
    @Test
    public void resetTest(){
        a.reset();
        Assert.assertFalse(a.isGameOn());
        a.setGameOn(true);
        a.reset();
        Assert.assertFalse(a.isGameOn());
        Assert.assertEquals(a.getPlayer().getX(), 200);
        Assert.assertEquals(a.getPlayer().getY(), 500);
        Assert.assertEquals(a.getShoot().getX(), 200);
        Assert.assertEquals(a.getShoot().getY(), 600);
        a.getPlayer().setX(10);
        a.getPlayer().setX(10);
        Assert.assertNotEquals(a.getPlayer().getX(), 200);
        Assert.assertNotEquals(a.getPlayer().getX(), 200);
        a.reset();
        Assert.assertEquals(a.getPlayer().getX(), 200);
        Assert.assertEquals(a.getPlayer().getX(), 200);
    }
    @Test
    public void reset2Test(){
        a.reset(1);
        Assert.assertFalse(a.isGameOn());
        Assert.assertEquals(a.getPlayer().getX(), 200);
        Assert.assertEquals(a.getPlayer().getY(), 500);
        Assert.assertEquals(a.getShoot().getX(), 200);
        Assert.assertEquals(a.getShoot().getY(), 600);
        Assert.assertEquals(a.getBoss().getX(), 200);
        Assert.assertEquals(a.getBoss().getY(), 200);
        Assert.assertEquals(a.getBoss().getSpeed(), 6);
        a.reset(2);
        Assert.assertEquals(a.getBoss().getSpeed(), 7);
    }

    @Test
    public void reset3Test(){
        a.reset(1, 5);
        Assert.assertFalse(a.isGameOn());
        Assert.assertEquals(a.getPlayer().getX(), 200);
        Assert.assertEquals(a.getPlayer().getY(), 500);
        Assert.assertEquals(a.getShoot().getX(), 200);
        Assert.assertEquals(a.getShoot().getY(), 600);
        Assert.assertEquals(a.getBoss().getX(), 200);
        Assert.assertEquals(a.getBoss().getY(), 200);
        Assert.assertEquals(a.getBoss().getSpeed(), 6);
        BasicAlien al = new BasicAlien(10, 10, 30, 20, 5, "alien.png");
        for(int i = 0; i < 5; i++) {
            Assert.assertEquals(a.getAlien1()[0][i].getX(), al.getX());
            al.setX(al.getX()+35);
        }
    }
    @Test
    public void hitDetectTest(){
        a.reset();
        a.getShoot().setX(10);
        a.getShoot().setY(10);
        a.hitDetect();
        Assert.assertEquals(a.getShoot().getX(), -30);
        Assert.assertFalse(a.getAlien1()[0][0].getVisible());
    }

    @Test
    public void winTest(){
        a.reset();
        Assert.assertFalse(a.win());
        for (int r = 0; r < a.getAlien1().length; r++) {
            for (int c = 0; c < a.getAlien1()[0].length; c++) {
                a.getAlien1()[r][c].setVisible(false);
            }
        }
        Assert.assertTrue(a.win());
    }
}
