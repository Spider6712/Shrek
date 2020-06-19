package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
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

    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;


    public LevelOne(MyGdxGame game)
    {
        this.myGame = game;

        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);

        world = new World(new Vector2( 0,0), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);

        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);


        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for (MapObject mapObject : map.getLayers().get(Constants.GROUND_LAYER).getObjects().getByType(PolygonMapObject.class))
        {
            Polygon polygon = ((PolygonMapObject)mapObject).getPolygon();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            float centerX = polygon.getOriginX();
            float centerY = polygon.getOriginY();
            bodyDef.position.set(centerX, centerY);

            body = world.createBody(bodyDef);

            shape.setAsBox(polygon.getOriginX(), polygon.getOriginY());
            fixtureDef.shape = shape;
            body.createFixture(fixtureDef);

        }

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

        renderer.render();

        box2DDebugRenderer.render(world, camera.combined);

        myGame.getBatch().begin();

        myGame.getBatch().setProjectionMatrix(camera.combined);

        myGame.getBatch().end();
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


