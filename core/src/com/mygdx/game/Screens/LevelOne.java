package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Constants;

public class LevelOne implements Screen {
    MyGdxGame myGame;
    Texture myImg;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public LevelOne(MyGdxGame game) {
        this.myGame = game;

        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);
    }
    @Override
    public void show()
    {


    }

    @Override
    public void render(float delta) {

         myGame.getBatch().begin();

         myGame.getBatch().draw(myImg, 0, 0);

         myGame.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}


