package com.hotmail.jack_m_os.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hotmail.jack_m_os.helloworld.activities.GameActivity;
import com.hotmail.jack_m_os.helloworld.helpers.NameFactory;

public class MainActivity extends Activity {

    EditText characterName;
    Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        characterName = (EditText) findViewById(R.id.edit_character_name);
        characterName.setText(NameFactory.generateCharacterName());
        startGameButton = (Button) findViewById(R.id.start_game);
        startGameButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                i.putExtra("name", characterName.getText().toString());
                setContentView(R.layout.loading_screen);
                startActivity(i);
            }
        });
    }

}
