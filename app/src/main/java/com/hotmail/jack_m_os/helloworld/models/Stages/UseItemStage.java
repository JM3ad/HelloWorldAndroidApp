package com.hotmail.jack_m_os.helloworld.models.Stages;

import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Item;
import com.hotmail.jack_m_os.helloworld.models.Stage;

public class UseItemStage implements Stage {
    private Character character;
    private Item item;
    private String stageText;
    private String optionOneText = "Use it";
    private String optionTwoText = "Ignore it";
    private String resultText;

    public UseItemStage(Character character, Item item){
        this.character = character;
        this.item = item;
        stageText = String.format("This looks like a great chance to use a %s", item.getName());
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
        if (character.attemptToUseItem(item)){
            resultText = item.getUseText();
            return;
        }
        resultText = "You don't own that item!";
    }

    public void performOptionTwo(){
        resultText = String.format("Nope, you don't fancy using the %s", item.getName());
    }

}
