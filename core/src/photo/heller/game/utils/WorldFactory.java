package photo.heller.game.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import photo.heller.game.box2d.GroundUserData;
import photo.heller.game.box2d.RunnerUserData;

public class WorldFactory {
    public static World createWorld() {
        return new World(Consts.WORLD_GRAVITY, true);
    }

    public static Body createGround(World xWorld) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Consts.GROUND_X, Consts.GROUND_Y));
        Body b = xWorld.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Consts.GROUND_WIDTH / 2, Consts.GROUND_HEIGHT / 2);
        b.createFixture(shape, Consts.GROUND_DENSITY);
        b.setUserData(new GroundUserData());
        shape.dispose();
        return b;
    }

    public static Body createRunner(World xWorld) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Consts.RUNNER_X, Consts.RUNNER_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Consts.RUNNER_WIDTH / 2, Consts.RUNNER_HEIGHT / 2);
        Body body = xWorld.createBody(bodyDef);
        body.setGravityScale(Consts.RUNNER_GRAVITY_SCALE);
        body.createFixture(shape, Consts.RUNNER_DENSITY);
        body.resetMassData();
        body.setUserData(new RunnerUserData());
        shape.dispose();
        return body;
    }

}
