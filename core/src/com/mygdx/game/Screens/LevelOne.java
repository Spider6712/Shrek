package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Constants;

public class LevelOne implements Screen
{
    MyGdxGame demoGame;

    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;


    MyGdxGame myGame;
    Texture myImg;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera camera;
    private Viewport viewport;


    public LevelOne(MyGdxGame game) {
        this.myGame = game;

        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);
        this.demoGame = game;


        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);
        this.demoGame = game;
        world = new World(new Vector2( 0,0), true);

        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for (: map.getLayers().get(Constants.))

        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
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
    public void dispose()
    {
        map.dispose();
        renderer.dispose();


    }
}


