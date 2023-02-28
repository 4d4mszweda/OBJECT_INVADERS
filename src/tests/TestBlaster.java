package tests;
import org.junit.Test;
import org.junit.Assert;
import weapon.Blaster;

public class TestBlaster {
    Blaster a = new Blaster(200, 500, 5, 20, 15, "shoot.png");
    @Test
    public void moveTest(){
        a.move(0);
        Assert.assertEquals(a.getY(), 600);
        a.setGoUp(true);
        a.move(0);
        Assert.assertEquals(a.getY(), 585);
        a.move(0);
        Assert.assertEquals(a.getY(), 570);
        a.setY(-1);
        a.move(0);
        Assert.assertEquals(a.getY(), 600);
    }
}
