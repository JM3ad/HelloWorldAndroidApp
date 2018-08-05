package com.hotmail.jack_m_os.helloworld.helpers;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Item;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Stages.CombatStage;
import com.hotmail.jack_m_os.helloworld.models.Stages.ShopStage;

import java.util.Random;

public class StageFactory {

    public static Stage getNextStage(Character character){
        int randInt = new Random().nextInt(100);
        if (randInt < 85){
            return getCombatStage(character);
        }
        return getShopStage(character);
    }

    private static CombatStage getCombatStage(Character character){
        Random random = new Random();
        int enemyHealth = Math.min(1, random.nextInt(character.getStrength()*2));
        int enemyStrength = Math.min(1, random.nextInt(character.getMaxHealth()/3));
        Enemy enemy = new Enemy(NameFactory.generateMonsterName(), enemyStrength, enemyHealth);
        return new CombatStage(character, enemy);
    }

    private static ShopStage getShopStage(Character character){
        Item item = new Item(NameFactory.generateItemName());
        return new ShopStage(character, item, 5);
    }


}
