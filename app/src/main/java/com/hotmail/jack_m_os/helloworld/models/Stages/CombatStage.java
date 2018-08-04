package com.hotmail.jack_m_os.helloworld.models.Stages;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;

public class CombatStage implements Stage {
    private Character character;
    private Enemy enemy;
    private String stageText;
    private String optionOneText = "Fight";
    private String optionTwoText = "Run";
    private String resultText;

    public CombatStage(Character character, Enemy enemy){
        this.character = character;
        this.enemy = enemy;
        stageText = String.format("You encounter a %s, do you want to fight it?", enemy.getName());
    }

    public String getStageText() {
        return stageText;
    }

    public String getOptionOneText() {
        return optionOneText;
    }

    public String getOptionTwoText() {
        return optionTwoText;
    }

    public String getResultText() {
        return resultText;
    }

    public void performOptionOne(){
        character.fight(enemy);
        //Add money?
        resultText = "Appropriate result";
    }

    public void performOptionTwo(){
        character.updateHealth(1);
        resultText = "You coward";
    }

}
