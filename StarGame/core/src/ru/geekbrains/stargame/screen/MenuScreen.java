package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture background;
    private Texture img;

    private Vector2 pos;
    private Vector2 v;
    private Vector2 nextPos;
    private float a; //acceleration

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        img = new Texture("star.png");
        pos = new Vector2(0, 0);
        nextPos = new Vector2(0, 0);
        v = new Vector2(0.5f, 0.3f);
        a = 0.08f;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
        v = nextPos.cpy().sub(pos);
        v.scl(a);
        pos.add(v);

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 19:
                nextPos.set(pos.add(0, 20));
                System.out.println("up");
                break;
            case 20:
                nextPos.set(pos.add(0, -20));
                System.out.println("down");
                break;
            case 21:
                nextPos.set(pos.add(-20, 0));
                System.out.println("left");
                break;
            case 22:
                nextPos.set(pos.add(20, 0));
                System.out.println("right");
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        nextPos.set(screenX,  Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
