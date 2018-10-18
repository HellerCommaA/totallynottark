package photo.heller.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import photo.heller.game.actors.Ground;
import photo.heller.game.actors.Runner;
import photo.heller.game.utils.BodyUtils;
import photo.heller.game.utils.WorldFactory;

public class GameStage extends Stage implements ContactListener {

    private final String TAG = GameStage.class.getSimpleName();

    // viewport measurements while working with debug renderer
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;

    private World mWorld;
    private Ground mGround;
    private Runner mRunner;

    private final float TIME_STEP = 1/300f;
    private float mAccumulator = 0f;

    private OrthographicCamera mCamera;
    private Box2DDebugRenderer mRenderer;

    public GameStage() {
        setKeyListener();
        setupWorld();
        setupCamera();
        mRenderer = new Box2DDebugRenderer();
    }

    private void setupWorld() {
        mWorld = WorldFactory.createWorld();
        mWorld.setContactListener(this);
        setupGround();
        setupRunner();
    }

    private void setupGround() {
        mGround = new Ground(WorldFactory.createGround(mWorld));
        addActor(mGround);
    }

    private void setupRunner() {
        mRunner = new Runner(WorldFactory.createRunner(mWorld));
        addActor(mRunner);
    }

    private void setupCamera() {
        mCamera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        mCamera.position.set(mCamera.viewportWidth / 2, mCamera.viewportHeight / 2, 0f);
        mCamera.update();
    }

    private void setKeyListener() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyUp(int keyCode) {
        if (keyCode == Input.Keys.A || keyCode == Input.Keys.D) {
            mRunner.stopDodge();
        }
        return super.keyUp(keyCode);
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            mRunner.jump();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            mRunner.dodge();
        }
        return super.keyDown(keyCode);
    }

    private void translateScreenToWorldCoordinates(int x, int y) {
//        getCamera().unproject(touch)
    }

    @Override
    public void act(float xDelta) {
        super.act(xDelta);
        mAccumulator += xDelta;
        while(mAccumulator >= xDelta) {
            mWorld.step(TIME_STEP, 6, 2);
            mAccumulator -= TIME_STEP;
        }
        // TODO: implement interpolation
    }

    @Override
    public void draw() {
        super.draw();
        mRenderer.render(mWorld, mCamera.combined);
    }

    @Override
    public void beginContact(Contact xContact) {
        Body a = xContact.getFixtureA().getBody();
        Body b = xContact.getFixtureB().getBody();
        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            mRunner.landed();
        }
    }

    @Override
    public void endContact(Contact xContact) {

    }

    @Override
    public void preSolve(Contact xContact, Manifold xOldManifold) {

    }

    @Override
    public void postSolve(Contact xContact, ContactImpulse xImpulse) {

    }
}
