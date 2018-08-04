package com.hotmail.jack_m_os.helloworld.models;

public class Enemy {
    private String name;
    private int strength;
    private int health;

    public Enemy(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
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

    public void damage(int value){
        health -= value;
    }
}
