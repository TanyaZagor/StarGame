package ru.geekbrains.stargame.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.base.SpritesPool;
import ru.geekbrains.stargame.sprite.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private Sound sound;
    private TextureRegion region;

    public ExplosionPool(TextureAtlas atlas, Sound sound) {
        this.region = atlas.findRegion("explosion");
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(region, 9, 9, 74, sound);
    }
}
