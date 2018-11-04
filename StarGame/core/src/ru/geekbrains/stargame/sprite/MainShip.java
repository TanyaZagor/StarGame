package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.pool.BulletPool;
import ru.geekbrains.stargame.screen.GameScreen;

public class MainShip extends Sprite {

    private Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();

    private boolean pressedLeft;
    private boolean pressedRight;
    private boolean canMoveLeft = true;
    private boolean canMoveRight = true;

    private BulletPool bulletPool;

    private TextureAtlas atlas;
    private Rect worldBounds;

    public MainShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        setHeightProportion(0.15f);
        this.bulletPool = bulletPool;
        this.atlas = atlas;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (isMe(touch)) {
            shoot();
        } else if (touch.x < 0) {
            pressedLeft = true;
            if (canMoveLeft) {
                moveLeft();
                canMoveRight = true;
            }
        } else if (touch.x > 0) {
            pressedRight = true;
            if (canMoveRight) {
                moveRight();
                canMoveLeft = true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (touch.x < 0) {
            pressedLeft = false;
            if (pressedRight) {
                if (canMoveRight)moveRight();
            } else {
                stop();
            }
        } else if (touch.x > 0) {
            pressedRight = false;
            if (pressedLeft) {
                if (canMoveLeft)moveLeft();
            } else {
                stop();
            }
        }
        return false;
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = true;
                if (canMoveLeft) {
                    moveLeft();
                    canMoveRight = true;
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = true;
                if (canMoveRight) {
                    moveRight();
                    canMoveLeft = true;
                }
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = false;
                if (pressedRight) {
                    if (canMoveRight) {
                        moveRight();
                        canMoveLeft = true;
                    }
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = false;
                if (pressedLeft) {
                    if (canMoveLeft) {
                        moveLeft();
                        canMoveRight = true;

                    }
                } else {
                    stop();
                }
                break;
            case Input.Keys.UP:
                shoot();
                break;
        }
        return false;
    }

    private void moveRight() {
        v.set(v0);
    }

    private void moveLeft() {
        v.set(v0).rotate(180);
    }

    private void stop() {
        v.setZero();
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (getRight() > worldBounds.getRight()) {
            canMoveRight = false;
            stop();
        } else if (getLeft() < worldBounds.getLeft()) {
            canMoveLeft = false;
            stop();
        }
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, atlas.findRegion("bulletMainShip"), pos,
                new Vector2(0, 0.5f), 0.01f, worldBounds, 1);
        bullet.sound.play(0.3f);
    }
}
