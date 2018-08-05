package com.hotmail.jack_m_os.helloworld.helpers;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Item;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Stages.CombatStage;
import com.hotmail.jack_m_os.helloworld.models.Stages.RestStage;
import com.hotmail.jack_m_os.helloworld.models.Stages.ShopStage;
import com.hotmail.jack_m_os.helloworld.models.Stages.UseItemStage;

import java.util.Random;

public class StageFactory {

    public static Stage getNextStage(Character character, int day){
        int randInt = new Random().nextInt(100);
        if (randInt < 12){
            return getShopStage(character);
        }
        if (randInt < 24){
            return getRestStage(character);
        }
        if (randInt < 30){
            return getUseItemStage(character);
        }
        return getCombatStage(character, day);
    }

    private static CombatStage getCombatStage(Character character, int day){
        Enemy enemy = FightHelper.generateEnemy(day);
        return new CombatStage(character, enemy);
    }

    private static ShopStage getShopStage(Character character){
        Item item = ItemHelper.getItem();
        int price = new Random().nextInt(10)+1;
        return new ShopStage(character, item, price);
    }

    private static RestStage getRestStage(Character character){
        int price = new Random().nextInt(5)+1;
        return new RestStage(character, price);
    }

    private static UseItemStage getUseItemStage(Character character){
        Item item = ItemHelper.getUsableItem();
        return new UseItemStage(character, item);
    }
}
