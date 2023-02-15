package simplegame;

public class Sorceress extends Character{
    public Sorceress() {
        hp = 1000;
        mp = 500;
    }

    @Override
    void info() {
        System.out.println("체력 : " + hp + "\n지능 : " + mp);

    }
}
