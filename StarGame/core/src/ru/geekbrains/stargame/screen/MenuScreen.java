package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.sprite.Background;
import ru.geekbrains.stargame.sprite.Button;
import ru.geekbrains.stargame.sprite.Star;

public class MenuScreen extends Base2DScreen {

    private static final int STAR_COUNT = 256;

    private Texture bgTexture;
    private Background background;

    private TextureAtlas textureAtlas;
    private Star[] stars;
    private Button playButton;
    private Button exitButton;



    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("bg.png");
        background = new Background(new TextureRegion(bgTexture));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i= 0; i < stars.length; i++) {
            stars[i] = new Star(textureAtlas);
        }
        playButton = new Button(textureAtlas, "btPlay", 0.3f, 0.2f);
        exitButton = new Button(textureAtlas, "btExit", 0.2f, -0.2f);


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i= 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
        playButton.draw(batch);
        exitButton.draw(batch);
        batch.end();
    }
    public void update(float delta) {
        for (int i= 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
        playButton.update(delta);
        exitButton.update(delta);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i= 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        textureAtlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }
}
