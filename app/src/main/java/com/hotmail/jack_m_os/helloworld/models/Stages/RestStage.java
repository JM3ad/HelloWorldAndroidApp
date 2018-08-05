package com.hotmail.jack_m_os.helloworld.models.Stages;

import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Item;
import com.hotmail.jack_m_os.helloworld.models.Stage;

public class RestStage implements Stage {
    private Character character;
    private int price;
    private String stageText;
    private String optionOneText = "Rest";
    private String optionTwoText = "Continue";
    private String resultText;

    public RestStage(Character character, int price){
        this.character = character;
        this.price = price;
        stageText = String.format("You stop at a local inn. The price to rest is %d gold", price);
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
        if (character.attemptToSpend(price)){
            character.restoreHealth();
            resultText = "You rest in comfort, and awaken feeling refreshed.";
            return;
        }
        resultText = "You can't afford that!";
    }

    public void performOptionTwo(){
        resultText = "You're determined to press on, and leave the inn";
    }

}
