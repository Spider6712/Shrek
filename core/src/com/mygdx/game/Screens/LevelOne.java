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

import Sprites.Player;

public class LevelOne implements Screen
{
//    private Box2DDebugRenderer box2DDebugRenderer;

    MyGdxGame myGame;

    private Player player;

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

        world = new World(new Vector2( 0,-10), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);

        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);

        loadMap();

        player = new Player(world);

        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;
        System.out.println(map.getLayers().get(Constants.GROUND_LAYER).getObjects().getByType(PolygonMapObject.class).size);
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

        renderer = new OrthogonalTiledMapRenderer(map);
    }
    @Override
    public void show()
    {


    }

    private void loadMap()
    {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(Constants.LEVEL_MAP_FILENAME);
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    private void update(float deltaTime)
    {
        world.step(1/60f, 6, 2);
        camera.update();
        renderer.setView(camera);
        camera.position.x = player.getBox2Body().getPosition().x;
    }

    private void handleInput(float dt)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
        {
            camera.position.x = player.box2Body.getPosition().x;

            Vector2 force = new Vector2(100f, 0);
            player.getBox2Body().applyLinearImpulse(force, player.getBox2Body().getWorldCenter(),true);
        }
    }

    @Override
    public void render(float delta)
    {
        update(delta);
        handleInput(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        myGame.getBatch().begin();

//        player.draw(myGame.getBatch());

        myGame.getBatch().end();
        myGame.getBatch().setProjectionMatrix(camera.combined);
        renderer.render();
        box2DDebugRenderer.render(world, camera.combined);
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


