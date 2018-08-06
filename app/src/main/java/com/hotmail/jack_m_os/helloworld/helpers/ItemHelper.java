package com.hotmail.jack_m_os.helloworld.helpers;

import com.hotmail.jack_m_os.helloworld.models.Item;

import java.util.Arrays;
import java.util.Random;

public class ItemHelper {
    private static Item[] usableItems = {
            new Item(
                    "Potion of healing",
                    null,
                    (character) -> {
                        character.restoreHealth();
                    },
                    "You feel much better"
            ),
            new Item(
                    "Wand of strength",
                    null,
                    (character) -> {
                        character.updateStrength(1);
                    },
                    "You feel stronger already"
            ),
            new Item(
                    "Money tree",
                    null,
                    (character) -> {
                        character.addMoney(25);
                    },
                    "I can't believe that worked"
            )
    };

    private static Item[] otherItems = {
            new Item(
                    "slightly bigger sword",
                    (character) -> {character.updateStrength(1);},
                    null,
                    null
            ),
            new Item(
                    "Large shield",
                    (character) -> {character.increaseMaxHealth(5);},
                    null,
                    null

            ),
            new Item(
                    "Strategist magazine",
                    (character) -> {character.updateExperience(25);},
                    null,
                    null
            ),
            new Item(
                    "Box of old condoms"
            )
    };

    public static Item getItem(){
        Item[] allItems = Arrays.copyOf(usableItems, usableItems.length + otherItems.length);
        System.arraycopy(otherItems, 0, allItems, usableItems.length, otherItems.length);
        return pickItemFromList(allItems);
    }

    public static Item getUsableItem(){
        return pickItemFromList(usableItems);
    }


    private static Item pickItemFromList(Item[] items){
        int random = new Random().nextInt(items.length);
        return items[random];
    }
}
