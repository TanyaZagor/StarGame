package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("star2.png");

		Vector2 v1 = new Vector2(2, 3);
		Vector2 v2 = new Vector2(0, -1);
		v1.add(v2);
		System.out.println("v1.x = " + v1.x + ", v1.y = " + v1.y);

		v1.set(3, 2);
		v2.set(1, 1);
		Vector2 v3 = v1.cpy().sub(v2);
		System.out.println("v1.x = " + v1.x + ", v1.y = " + v1.y);
		System.out.println("v3.x = " + v3.x + ", v3.y = " + v3.y);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
