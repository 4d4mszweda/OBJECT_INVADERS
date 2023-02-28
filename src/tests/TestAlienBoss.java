package tests;
import characters.AlienBoss;
import characters.BasicAlien;
import characters.Player;
import org.junit.Test;
import org.junit.Assert;
import weapon.Blaster;

public class TestAlienBoss {
    AlienBoss a = new AlienBoss(10, 10, 30, 20, 5, "alien.png");

    @Test
    public void moveTest(){
        a.setMoveLeft(true);
        a.setMoveRight(false);
        a.move(0);
        Assert.assertEquals(a.getX(), 5);
        a.move(0);
        Assert.assertEquals(a.getX(), 0);
        a.setMoveRight(true);
        a.setMoveLeft(false);
        a.move(0);
        Assert.assertEquals(a.getX(), 5);
        a.move(0);
        Assert.assertEquals(a.getX(), 10);
    }
    @Test
    public void damageTest(){
        a.damage();
        Assert.assertEquals(a.getHp(), 2);
        a.damage();
        Assert.assertEquals(a.getHp(), 1);
        a.damage();
        Assert.assertEquals(a.getHp(), 0);
    }
    @Test
    public void phase2Test(){
        a.phase2();
        Blaster x = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        Assert.assertEquals(a.getSpeed(), 8);
        Assert.assertFalse(a.getAmunicja().contains(x));
    }
    @Test
    public void phase3Test(){
        a.phase3();
        Blaster x = new Blaster(200, 500, 5, 20, 15, "shoot.png");
        Assert.assertEquals(a.getSpeed(), 11);
        Assert.assertFalse(a.getAmunicja().contains(x));
    }
    @Test
    public void speedsterTest(){
        a.speedster();
        Assert.assertEquals(a.getSpeed(), 8);
        a.speedster();
        Assert.assertEquals(a.getSpeed(), 11);
        a.speedster();
        Assert.assertEquals(a.getSpeed(), 14);
    }
}