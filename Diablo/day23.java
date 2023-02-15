package Diablo;

public class day23 {
    public static void main(String[] args) {
        Barbarian b1 = new Barbarian();
        Sorceress s1 = new Sorceress();
        Bow windForce = new Bow();
        Axe berserkerAxe = new Axe();
        s1.setWeapon(windForce);    // get weapon
        s1.performWeapon();
        b1.setWeapon((berserkerAxe));
        b1.performWeapon();
        s1.setWeapon(new Axe());
        s1.performWeapon();
        s1.info();
        b1.setWeapon(()-> System.out.println("신오브로 아이스볼을 발사"));
        b1.performWeapon();
    }
}
