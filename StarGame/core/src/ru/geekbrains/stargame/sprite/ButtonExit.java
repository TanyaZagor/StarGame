package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.geekbrains.stargame.base.ActionListener;
import ru.geekbrains.stargame.base.ScaledTouchUpButton;
import ru.geekbrains.stargame.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {
    public ButtonExit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), actionListener);
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.2f);
    }
}
