package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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
//    private Box2DDebugRenderer box2DDebugRenderer;

    MyGdxGame myGame;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera camera;
    private Viewport viewport;


    public LevelOne(MyGdxGame game)
    {
        this.myGame = game;

        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);

//        world = new World(new Vector2( 0,0), true);

        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);

        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);


//        BodyDef bodyDef = new BodyDef();
//        PolygonShape shape = new PolygonShape();
//        FixtureDef fixtureDef = new FixtureDef();
//        Body body;

//        for ( : map.getLayers().get(2)) {
//
//        }

    }
    @Override
    public void show()
    {


    }

    private void update(float deltaTime)
    {
        camera.update();
        renderer.setView(camera);
    }

    private void handleInput(float dt)
    {
//        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
//        {
////            camera.position.x = player.getbody.x
//        }
    }

    @Override
    public void render(float delta)
    {
        update(delta);
        handleInput(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        myGame.getBatch().begin();
//
//        myGame.getBatch().draw(myImg, 0, 0);
//

        myGame.getBatch().setProjectionMatrix(camera.combined);

//        myGame.getBatch().end();


        renderer.render();
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height);

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        map.dispose();
        renderer.dispose();


    }
}


