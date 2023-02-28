package characters;
import weapon.Blaster;
import weapon.Laser;
import weapon.Weapon;
import java.util.ArrayList;

public class AlienBoss extends BasicAlien implements Boss{

    private int hp = maxHp;
    private ArrayList<Weapon> amunicja;
    private Blaster a[] = new Blaster[3];
    private Laser b[] = new Laser[3];

    public AlienBoss(){}
    public AlienBoss(int x, int y, int w, int h, int speed, String u){
        super(x, y, w, h, speed, u);
        this.amunicja = new ArrayList<>();
    }

    @Override
    public void phase2() {
        a[0]=new Blaster(200, 500, 5, 20, 15, "shoot.png");
        a[1]=new Blaster(200, 500, 5, 20, 15, "shoot.png");
        a[2]=new Blaster(200, 500, 5, 20, 15, "shoot.png");
        amunicja.add(a[0]);
        amunicja.add(a[1]);
        amunicja.add(a[2]);
        speedster();
    }

    @Override
    public void phase3() {
        speedster();
        speedster();
        amunicja.add(b[0]=new Laser(200, 500, 15, "laser.png"));
        amunicja.add(b[1]=new Laser(200, 500, 15, "laser.png"));
        amunicja.add(b[2]=new Laser(200, 500, 15, "laser.png"));
    }

    @Override
    public void speedster() {
        setSpeed(getSpeed()+3);
    }

    @Override
    public void damage() {
        this.hp -= 1;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
    public void removeAmunicja(Weapon x){
        amunicja.remove(x);
    }

    public ArrayList<Weapon> getAmunicja() {
        return amunicja;
    }
}
