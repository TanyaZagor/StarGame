package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {


    private Texture img;

    private Vector2 touchDownPos;
    private Vector2 v;
    private Vector2 buf;
    private Vector2 pos;


    @Override
    public void show() {
        super.show();
        img = new Texture("star2.jpg");
        pos = new Vector2(0, 0);
        touchDownPos = new Vector2();
        v = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        buf.set(touchDownPos);
        if (buf.sub(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(touchDownPos);
        }
        batch.begin();
        batch.draw(img,pos.x, pos.y, 0.05f, 0.05f);
        batch.end();


    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        touchDownPos = touch;
        v.set(touchDownPos.cpy().sub(pos).scl(0.01f));
        return false;
    }
}
