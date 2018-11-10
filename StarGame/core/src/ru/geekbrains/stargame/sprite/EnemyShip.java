package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Ship;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.pool.BulletPool;

public class EnemyShip extends Ship {
    private Vector2 v0 = new Vector2();
    private Vector2 vf = new Vector2(0, -0.4f);


    public EnemyShip(BulletPool bulletPool, Rect worldBounds, Sound shootSound) {
        super(shootSound);
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.v.set(v0);
    }
    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0f, bulletVY);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.hp = hp;
        setHeightProportion(height);
        v.set(v0);
    }

    @Override
    public void update(float delta) {
        if (getTop() < worldBounds.getTop()) {
            this.pos.mulAdd(v, delta);
            reloadTimer += delta;
            if (reloadTimer >= reloadInterval) {
                shoot();
                reloadTimer = 0f;
            }
        } else {
            this.pos.mulAdd(vf, delta);
        }

    }

}
