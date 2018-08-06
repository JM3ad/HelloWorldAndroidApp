package com.hotmail.jack_m_os.helloworld.helpers;
import java.util.Random;

public class NameFactory {
    private static String[] characterNames = new String[]{"Draenor", "Wolfgram", "Demonto", "Joe"};
    private static String[] monsterNames = new String[]{"goblin", "ogre", "kobold", "Artemis the Defiler", "hungry orphan", "panther"};

    public static String generateCharacterName(){
        return pickNameFromList(characterNames);
    }

    public static String generateMonsterName(){
        return pickNameFromList(monsterNames);
    }

    private static String pickNameFromList(String[] names){
        int random = new Random().nextInt(names.length);
        return names[random];
    }
}
