package com.hotmail.jack_m_os.helloworld.models.Stages;

import com.hotmail.jack_m_os.helloworld.helpers.FightHelper;
import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;

import java.util.Random;

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
        FightHelper.fight(character, enemy);
        if (character.isDead()){
            resultText = "You are dead!";
            return;
        }
        character.addMoney(enemy.getLoot());
        character.updateExperience(enemy.getStrength() * 3);
        resultText = "You killed the enemy!";
    }

    public void performOptionTwo(){
        if (fleesSuccessfully()){
            resultText = "Your fleet feet carry you out safely";
            return;
        }
        resultText = "You flee, though not fast enough to avoid a parting blow";
        character.updateHealth(-enemy.getStrength());
        if (character.isDead()){
            resultText = "You are dead!";
        }
    }

    private boolean fleesSuccessfully(){
        return new Random().nextInt(3) > 0;
    }
}
