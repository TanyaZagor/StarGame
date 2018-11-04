package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.geekbrains.stargame.base.ActionListener;
import ru.geekbrains.stargame.base.ScaledTouchUpButton;
import ru.geekbrains.stargame.math.Rect;

public class ButtonPlay extends ScaledTouchUpButton {
    public ButtonPlay(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btPlay"), actionListener);
        setHeightProportion(0.3f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop() - 0.2f);
    }
}
