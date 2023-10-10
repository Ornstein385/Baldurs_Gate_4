package org.example;

public class Player extends Unit {
    private int healsCnt = 4;

    public int getHealsCnt() {
        return healsCnt;
    }

    public void setHealsCnt(int healsCnt) {
        this.healsCnt = healsCnt;
    }

    public Player(int hp, int maxHp, int atk, int def, int maxDmg, int minDmg, String name) {
        super(hp, maxHp, atk, def, maxDmg, minDmg, name);
    }


    public void heal() {
        if (healsCnt > 0) {
            setHp(Math.min(getMaxHp(), getHp() + (int) (Math.max(getMaxHp() * 0.3, 1))));
            healsCnt--;
            System.out.println(name + " лечится на " + (int) (Math.max(getMaxHp() * 0.3, 1)) + " hp");
        }
    }
}
