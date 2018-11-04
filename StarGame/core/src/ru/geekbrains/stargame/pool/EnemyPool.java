package ru.geekbrains.stargame.pool;

import ru.geekbrains.stargame.base.SpritesPool;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {
    @Override
    protected EnemyShip newObject() {
        return new EnemyShip();
    }

    public void resize(Rect worldBounds) {
        super.resizeActiveObjects(worldBounds);
    }
}
