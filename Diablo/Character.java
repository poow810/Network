package Diablo;

public abstract class Character {
    protected int hp;
    protected int mp;
    // ...

    WeaponBehavior weapon; // Association 상속이 아니라 부품처럼 Diablo.Character type의 변수가 weapon을 사용함

    public void info(){
        System.out.println("체력 : " + hp + "\n지능 : " + mp);
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public final void performWeapon(){
        weapon.useWeapon();
    }
}
