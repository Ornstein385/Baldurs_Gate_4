package org.example;

public class Unit {
    private int hp, maxHp, atk, def, maxDmg, minDmg;

    public final String name;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public Unit(int hp, int maxHp, int atk, int def, int maxDmg, int minDmg, String name) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.atk = atk;
        this.def = def;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
        this.name = name;
        if (hp < 1 || maxHp < 1 || atk < 1 || atk > 30 || def < 1 || def > 30 || maxDmg < 1 || minDmg < 0 || minDmg > maxDmg || name == null){
            throw new IllegalArgumentException();
        }
    }

    public int attack(Unit unit) {
        int mod = atk - unit.getDef() + 1;
        int dmg = 0;
        if (isSuccessfulAttack(mod)) {
            dmg = minDmg + (int) ((maxDmg - minDmg + 1) * Math.random());
            unit.setHp(Math.max(unit.getHp() - dmg, 0));
            System.out.println(name + " наносит " + dmg + " урона");
        } else {
            System.out.println(name + " промахивается");
        }
        return dmg;
    }

    private boolean isSuccessfulAttack(int n) {
        n = Math.max(n, 1);
        double p = Math.pow(2.0 / 3, n);
        return Math.random() >= p;
    }
}
