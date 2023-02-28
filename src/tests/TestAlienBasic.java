package tests;
import characters.BasicAlien;
import characters.Player;
import org.junit.Test;
import org.junit.Assert;

public class TestAlienBasic {
    BasicAlien a = new BasicAlien(10, 10, 30, 20, 5, "alien.png");

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
}
