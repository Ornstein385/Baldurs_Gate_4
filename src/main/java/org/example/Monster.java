package org.example;

public class Monster extends Unit {

    public Monster(int hp, int maxHp, int atk, int def, int maxDmg, int minDmg, String name) {
        super(hp, maxHp, atk, def, maxDmg, minDmg, name);
    }

    public void regen() {
        if (getHp() < getMaxHp()) {
            setHp(getHp() + 1);
            System.out.println(name + " регенерирует 1 hp");
        }
    }

    @Override
    public int attack(Unit unit) {
        int x = super.attack(unit);
        if (x > 0){
            regen();
            System.out.println(name + " регенерирует 1 hp за успешный удар");
        }
        return x;
    }
}
