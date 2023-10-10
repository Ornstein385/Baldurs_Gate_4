package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    Player player;
    ArrayList<Monster> monsters;

    public Game(Player player, Monster... monsters) {
        this.player = player;
        this.monsters = new ArrayList<>(Arrays.asList(monsters));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (!monsters.isEmpty() && player.getHp() > 0) {
            showInfo();
            System.out.println("ходит игрок. его действия:");
            System.out.println("0: лечиться");
            for (int i = 0; i < monsters.size(); i++) {
                System.out.println(i + 1 + ": атаковать. цель - " + monsters.get(i).name);
            }
            String s;
            do {
                System.out.println("введите номер действия");
                s = sc.nextLine();
            } while (!isNumber(s) && Integer.parseInt(s) < 0 && Integer.parseInt(s) >= monsters.size());
            int x = Integer.parseInt(s);
            if (x == 0) {
                player.heal();
            } else {
                player.attack(monsters.get(x - 1));
                if (monsters.get(x - 1).getHp() == 0) {
                    System.out.println(monsters.get(x - 1).name + " убит");
                    monsters.remove(x - 1);
                }
            }
            for (Monster monster : monsters) {
                monster.attack(player);
                if (player.getHp() == 0) {
                    System.out.println("игрок убит");
                    break;
                }
            }
        }
        if (monsters.isEmpty()) {
            System.out.println("игрок победил!");
        }
        sc.close();
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showInfo() {
        System.out.println("======================");
        System.out.println("у игрока " + player.getHp() + " hp и " + player.getHealsCnt() + " зелий лечения");
        for (Monster monster : monsters) {
            System.out.println("у " + monster.name + " " + monster.getHp() + " hp");
        }
        System.out.println("======================");
    }
}
