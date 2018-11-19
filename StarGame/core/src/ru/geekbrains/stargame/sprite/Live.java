package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;

public class Live extends Sprite {

    private int nLive;
    private Rect worldBounds;

    public Live(TextureRegion region, int nLive) {
        super(region);
        setHeightProportion(0.05f);
        this.nLive = nLive;
    }

    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setPos();
    }

    public void setPos() {
        switch (nLive) {
            case 0:
                pos.x = worldBounds.pos.x - getWidth() * 2;
                setTop(worldBounds.getTop());
                break;
            case 1:

                pos.x = worldBounds.pos.x - getWidth();
                setTop(worldBounds.getTop());
                break;
            case 2:
                pos.x = worldBounds.pos.x;
                setTop(worldBounds.getTop());
                break;
            case 3:
                pos.x = worldBounds.pos.x + getWidth();
                setTop(worldBounds.getTop());
                break;
            case 4:
                pos.x = worldBounds.pos.x + getWidth() * 2;
                setTop(worldBounds.getTop());
                break;
        }
    }
}
