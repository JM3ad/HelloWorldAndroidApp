package com.hotmail.jack_m_os.helloworld.models;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private int Money;
    private int Health;
    private int MaxHealth;
    private int Strength;
    private String Name;
    private Map<String, Item> Inventory;


    public Character(String name) {
        Money = 0;
        MaxHealth = 10;
        Health = MaxHealth;
        Strength = 1;
        this.Name = name;
        Inventory = new HashMap();
    }

    public int getMoney() {
        return Money;
    }

    public String getName() {
        return Name;
    }

    public int getHealth() {
        return Health;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public int getStrength() {
        return Strength;
    }

    public boolean isDead() { return Health <= 0; }

    public void updateStrength(int value) {
        Strength = Math.max(0, Strength + value);
    }

    public void updateHealth(int value) {
        if (value > 0) {
            Health = Math.min(MaxHealth, Health + value);
            return;
        }
        Health = Math.max(0, Health + value);
    }

    public boolean HasItem(Item item) {
        return Inventory.containsKey(item.Name);
    }

    public boolean AttemptToUseItem(Item item) {
        if (HasItem(item)) {
            Inventory.remove(item.Name);
            return true;
        }
        return false;
    }

    public void AddMoney(int value) {
        Money += value;
    }

    public boolean AttemptToPurchase(Item item, int cost) {
        if (Money < cost) {
            return false;
        }
        PurchaseItem(item, cost);
        return true;
    }

    private void PurchaseItem(Item item, int cost) {
        Money -= cost;
        Inventory.put(item.Name, item);
    }

    public boolean fight(Enemy enemy){
        while(enemy.getHealth() > 0){
            enemy.damage(Strength);
            updateHealth(-enemy.getStrength());
        }
        if (Health > 0){
            return true;
        }
        return false;
    }

}
