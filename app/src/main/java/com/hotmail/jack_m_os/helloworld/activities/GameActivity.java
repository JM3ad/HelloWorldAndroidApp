package com.hotmail.jack_m_os.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hotmail.jack_m_os.helloworld.MainActivity;
import com.hotmail.jack_m_os.helloworld.R;
import com.hotmail.jack_m_os.helloworld.models.Character;
import com.hotmail.jack_m_os.helloworld.models.Stage;
import com.hotmail.jack_m_os.helloworld.models.Story;

public class GameActivity extends AppCompatActivity {

    private Character character;
    private TextView storyText;
    private TextView healthText;
    private TextView moneyText;
    private Button optionOne;
    private Button optionTwo;
    private Button continueButton;
    private Story story;
    private Stage stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        String charName = getIntent().getStringExtra("name");
        character = new Character(charName);
        story = new Story(character);
        setButtons();
        storyText = (TextView) findViewById(R.id.story);
        moneyText = (TextView) findViewById(R.id.money);
        healthText = (TextView) findViewById(R.id.hp);
        stage = story.GetCurrentStage();
        refreshText();
    }

    private void setButtons(){
        optionOne = (Button) findViewById(R.id.option_1);
        optionOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stage.performOptionOne();
                optionOne.setVisibility(View.INVISIBLE);
                optionTwo.setVisibility(View.INVISIBLE);
                continueButton.setVisibility(View.VISIBLE);
                refreshText();
                displayCompletionText();
            }
        });
        optionTwo = (Button) findViewById(R.id.option_2);
        optionTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stage.performOptionTwo();
                optionOne.setVisibility(View.INVISIBLE);
                optionTwo.setVisibility(View.INVISIBLE);
                continueButton.setVisibility(View.VISIBLE);
                refreshText();
                displayCompletionText();
            }
        });
        continueButton = (Button) findViewById(R.id.next_stage);
        continueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (character.isDead()){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    setContentView(R.layout.loading_screen);
                    startActivity(i);
                    return;
                }
                stage = story.GetCurrentStage();
                refreshText();
                story.progressStage();
                storyText.setText(stage.getStageText());
                optionOne.setVisibility(View.VISIBLE);
                optionTwo.setVisibility(View.VISIBLE);
                continueButton.setVisibility(View.INVISIBLE);
                continueButton.setText("Continue");
            }
        });
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
