package com.hotmail.jack_m_os.helloworld.models;

import java.util.Random;

public class Enemy {
    private String name;
    private int strength;
    private int health;
    private int loot;

    public Enemy(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.loot = Math.max(new Random().nextInt(strength * 4 + 1), 1);
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getLoot() { return loot; }

    public void damage(int value){
        health -= value;
    }
}
