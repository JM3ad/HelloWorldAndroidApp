package com.hotmail.jack_m_os.helloworld.models;

import com.hotmail.jack_m_os.helloworld.helpers.StageFactory;

public class Story {
    public int stageCount;
    public Character character;
    private Stage stage;

    public Story(Character character){
        this.character = character;
        stage = StageFactory.getNextStage(this.character, stageCount);
    }

    public Stage getCurrentStage(){
        return stage;
    }

    public void progressStage() {
        stageCount++;
        stage = StageFactory.getNextStage(character, stageCount);
    }
}
