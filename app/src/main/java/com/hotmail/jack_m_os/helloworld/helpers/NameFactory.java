package com.hotmail.jack_m_os.helloworld.helpers;
import java.util.Random;

public class NameFactory {
    private static String[] listOfNames = new String[]{"Draenor", "Wolfgram", "Demonto"};

    public static String GenerateName(){
        int random = new Random().nextInt(listOfNames.length);
        return listOfNames[random];
    }
}
