package com.hotmail.jack_m_os.helloworld.models.Stages;

import com.hotmail.jack_m_os.helloworld.models.Enemy;
import com.hotmail.jack_m_os.helloworld.models.Item;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Character;

public class ShopStage implements Stage {
    private Character character;
    private Item item;
    private int price;
    private String stageText;
    private String optionOneText = "Purchase";
    private String optionTwoText = "Decline";
    private String resultText;

    public ShopStage(Character character, Item item, int price){
        this.character = character;
        this.item = item;
        this.price = price;
        stageText = String.format("Passing through a local town, a shopkeep beckons you in. Would you like this %s he asks? Only %d gold!", item.name, price);
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
        boolean purchased = character.attemptToPurchase(item, price);
        if (purchased){
            resultText = String.format("You buy the %s. Nice!", item.name);
            return;
        }
        resultText = "You can't afford that!";
    }

    public void performOptionTwo(){
        resultText = "You move on, unexcited by the purchase";
    }

}
