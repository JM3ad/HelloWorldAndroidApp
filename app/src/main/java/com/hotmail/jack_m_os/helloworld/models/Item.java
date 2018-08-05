package com.hotmail.jack_m_os.helloworld.models;

import java.util.function.Consumer;

public class Item {
    private String name;
    private String useText;
    private boolean hasUsedEffect;
    private Consumer<Character> useEffect;
    private boolean hasImmediateEffectBeenUsed;
    private Consumer<Character> immediateEffect;

    public Item(String name){
        this.name = name;
    }

    public Item(String name, Consumer<Character> immediateEffect, Consumer<Character> useEffect, String useText){
        this(name);
        this.immediateEffect = immediateEffect;
        this.useEffect = useEffect;
        this.useText = useText;
    }

    public void applyImmediateEffect(Character character){
        if (immediateEffect != null && !hasImmediateEffectBeenUsed){
            immediateEffect.accept(character);
            hasImmediateEffectBeenUsed = true;
        }
    }

    public void useItem(Character character){
        if (useEffect != null && !hasUsedEffect){
            hasUsedEffect = true;
            useEffect.accept(character);
        }
    }

    public String getName(){
        return name;
    }

    public String getUseText(){
        return useText;
    }
}
