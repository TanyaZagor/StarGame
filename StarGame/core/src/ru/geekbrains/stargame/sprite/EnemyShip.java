package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.math.Rnd;
import ru.geekbrains.stargame.utils.Regions;

public class EnemyShip extends Sprite {
    private Rect worldBounds;
    private Vector2 v = new Vector2();

    public EnemyShip() {
        regions = new TextureRegion[1];
    }
    public void set(
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height
    ) {
        this.regions = Regions.split(region, 1, 2, 2);
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        super.resize(worldBounds);
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        if (getTop() < worldBounds.getBottom() ) {
            this.pos.set(Rnd.nextFloat(-0.5f, 0.5f) , Rnd.nextFloat(0.5f, 0.8f));
        }
    }

}
