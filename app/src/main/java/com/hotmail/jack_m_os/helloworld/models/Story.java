package com.hotmail.jack_m_os.helloworld.models;

import com.hotmail.jack_m_os.helloworld.helpers.StageFactory;

public class Story {
    public int stageCount;
    public Character Character;
    private Stage stage;

    public Story(Character character){
        Character = character;
        stage = StageFactory.getNextStage(Character);
    }

    public Stage GetCurrentStage(){
        return stage;
    }

    public void progressStage() {
        stage = StageFactory.getNextStage(Character);
        stageCount++;
    }
}
