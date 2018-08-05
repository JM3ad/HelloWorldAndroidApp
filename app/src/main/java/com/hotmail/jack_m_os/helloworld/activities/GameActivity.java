package com.hotmail.jack_m_os.helloworld.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hotmail.jack_m_os.helloworld.MainActivity;
import com.hotmail.jack_m_os.helloworld.R;
import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Story;

public class GameActivity extends Activity {

    //region Properties
    private Character character;
    private TextView storyText;
    private TextView healthText;
    private TextView moneyText;
    private Button optionOne;
    private Button optionTwo;
    private Button continueButton;
    private Story story;
    private Stage stage;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initialiseProperties();
        setButtonClickEvents();
        refreshText();
    }

    private void initialiseProperties(){
        String charName = getIntent().getStringExtra("name");
        character = new Character(charName);
        story = new Story(character);
        storyText = (TextView) findViewById(R.id.story);
        storyText.setText(String.format("Welcome to your adventure %s", charName));
        moneyText = (TextView) findViewById(R.id.money);
        healthText = (TextView) findViewById(R.id.hp);
        optionOne = (Button) findViewById(R.id.option_1);
        optionTwo = (Button) findViewById(R.id.option_2);
        continueButton = (Button) findViewById(R.id.next_stage);
        stage = story.getCurrentStage();
    }

    private void setButtonClickEvents(){
        optionOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stage.performOptionOne();
                optionSelected();
            }
        });
        optionTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stage.performOptionTwo();
                optionSelected();
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (character.isDead()){
                    returnToMainScreen();
                    return;
                }
                continueSelected();
            }
        });
    }

    private void continueSelected(){
        showOptionButtons(true);
        stage = story.getCurrentStage();
        refreshText();
        story.progressStage();
        storyText.setText(stage.getStageText());
        continueButton.setText("Continue");
    }

    private void returnToMainScreen(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        setContentView(R.layout.loading_screen);
        startActivity(i);
    }

    private void optionSelected(){
        showOptionButtons(false);
        refreshText();
        displayCompletionText();
    }

    private void showOptionButtons(boolean showOptions){
        int optionVisibility = showOptions ? View.VISIBLE : View.INVISIBLE;
        int continueVisibility = showOptions ? View.INVISIBLE : View.VISIBLE;
        optionOne.setVisibility(optionVisibility);
        optionTwo.setVisibility(optionVisibility);
        continueButton.setVisibility(continueVisibility);
    }

    private void displayCompletionText(){
        storyText.setText(stage.getResultText());
    }

    private void refreshText(){
        optionOne.setText(stage.getOptionOneText());
        optionTwo.setText(stage.getOptionTwoText());
        moneyText.setText(String.format("%d GP",character.getMoney()));
        healthText.setText(String.format("%d /%d HP",character.getHealth(), character.getMaxHealth()));
    }

}
