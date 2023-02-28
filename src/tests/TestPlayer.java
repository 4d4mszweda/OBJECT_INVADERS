package tests;
import characters.Player;
import org.junit.Test;
import org.junit.Assert;


public class TestPlayer {
    Player a = new Player(200, 500, 57, 35, 5, "player.png");
    @Test
    public void stopTest(){
        a.stop();
        Assert.assertFalse(a.getMoveLeft());
        Assert.assertFalse(a.getMoveRight());
        a.setMoveRight(true);
        a.setMoveLeft(true);
        a.stop();
        Assert.assertFalse(a.getMoveLeft());
        Assert.assertFalse(a.getMoveRight());
    }
    @Test
    public void setLeftRightTest(){
        a.setLeftRight(37);
        Assert.assertTrue(a.getMoveLeft());
        a.setLeftRight(39);
        Assert.assertTrue(a.getMoveRight());
    }

    @Test
    public void moveTest(){
        a.stop();
        a.setMoveLeft(true);
        a.move(0);
        Assert.assertEquals(a.getX(), 195);
        a.move(0);
        Assert.assertEquals(a.getX(), 190);
        a.stop();
        a.setMoveRight(true);
        a.move(0);
        Assert.assertEquals(a.getX(), 195);
        a.move(0);
        Assert.assertEquals(a.getX(), 200);
    }
}
