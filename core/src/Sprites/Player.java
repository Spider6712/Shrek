package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Sprite
{
    private World world;
    public Body box2Body;

    public Player(World world)
    {
        this.world = world;
        definePlayerBox2d();

    }
    public void definePlayerBox2d()
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(50,150);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        box2Body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape polygonShape = new CircleShape();
        polygonShape.setRadius(5);

        fixtureDef.shape = polygonShape;
        box2Body.createFixture(fixtureDef);
    }

    public Body getBox2Body()
    {
        return box2Body;
    }
}

