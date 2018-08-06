package com.hotmail.jack_m_os.helloworld.models;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private int money;
    private int health;
    private int maxHealth;
    private int strength;
    private int experience;
    private int level;
    private String name;
    private Map<String, Item> inventory;

    public Character(String name) {
        money = 0;
        maxHealth = 10;
        health = maxHealth;
        strength = 1;
        this.name = name;
        experience = 0;
        level = 1;
        inventory = new HashMap();
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isDead() { return health <= 0; }

    public void updateStrength(int value) {
        strength = Math.max(0, strength + value);
    }

    public void updateHealth(int value) {
        if (value > 0) {
            health = Math.min(maxHealth, health + value);
            return;
        }
        health = Math.max(0, health + value);
    }

    public void updateExperience(int increase){
        experience += increase;
        while(experience > level * 10){
            experience -= level*10;
            levelUp();
        }
    }

    private void levelUp(){
        level++;
        maxHealth +=2;
        updateHealth(2);
        strength +=1;
    }

    public boolean hasItem(Item item) {
        return inventory.containsKey(item.getName());
    }

    public boolean attemptToUseItem(Item item) {
        if (hasItem(item)) {
            inventory.remove(item.getName());
            item.useItem(this);
            return true;
        }
        return false;
    }

    public void addMoney(int value) {
        money += value;
    }

    public boolean attemptToPurchase(Item item, int cost) {
        if (money < cost) {
            return false;
        }
        purchaseItem(item, cost);
        return true;
    }

    public boolean attemptToSpend(int cost){
        if (money >= cost){
            money -= cost;
            return true;
        }
        return false;
    }

    public void restoreHealth(){
        if (!isDead()){
            health = maxHealth;
        }
    }

    public void increaseMaxHealth(int value){
        if (!isDead()){
            maxHealth += value;
            health += value;
        }
    }

    private void purchaseItem(Item item, int cost) {
        money -= cost;
        addItem(item);
    }

    private void addItem(Item item){
        inventory.put(item.getName(), item);
        item.applyImmediateEffect(this);
    }

    public void damage(int strength){
        updateHealth(-strength);
    }

}
