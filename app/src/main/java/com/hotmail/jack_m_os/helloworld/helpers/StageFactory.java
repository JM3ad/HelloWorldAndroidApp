package com.hotmail.jack_m_os.helloworld.helpers;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Stages.CombatStage;

public class StageFactory {
    public static Stage getNextStage(Character character){
        Enemy enemy = new Enemy("Goblin", 1, 1);
        return new CombatStage(character, enemy);
    }
}
