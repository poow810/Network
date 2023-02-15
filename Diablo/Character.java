package simplegame;

public abstract class Character {
    protected int hp;
    protected int mp;
    // ...

    WeaponBehavior weapon; // Association 상속이 아니라 부품처럼 simplegame.Character type의 변수가 weapon을 사용함

    abstract void info();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public final void performWeapon(){
        weapon.useWeapon();
    }
}
