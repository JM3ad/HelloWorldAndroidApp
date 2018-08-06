package com.hotmail.jack_m_os.helloworld.helpers;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Character;

import java.util.Random;

public class FightHelper {
    public static void fight(Character character, Enemy enemy){
        while(enemy.getHealth() > 0 && character.getHealth() > 0){
            enemy.damage(character.getStrength());
            character.damage(enemy.getStrength());
        }
    }

    public static Enemy generateEnemy(int day){
        Random random = new Random();
        int health = Math.max(1, random.nextInt(day / 5 + 1));
        int strength = Math.max(1, random.nextInt(day / 6 + 1));
        String name = NameFactory.generateMonsterName();
        return new Enemy(name, strength, health);
    }
}
