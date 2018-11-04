package ru.geekbrains.stargame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.geekbrains.stargame.base.Base2DScreen;
import ru.geekbrains.stargame.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
