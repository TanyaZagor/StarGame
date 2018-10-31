package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.stargame.base.Sprite;

public class Button extends Sprite {

    float height;

    public Button(TextureAtlas atlas, String name, float height, float shift) {
        super(atlas.findRegion(name));
        this.height = height;
        setHeightProportion(height);
        pos.set(0, shift);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }
}
