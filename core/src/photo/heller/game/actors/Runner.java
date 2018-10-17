package photo.heller.game.actors;

import com.badlogic.gdx.physics.box2d.Body;
import photo.heller.game.box2d.RunnerUserData;
import photo.heller.game.box2d.UserData;

public class Runner extends GameActor {

    private boolean mIsJumping;

    public Runner(Body xBody) {
        super(xBody);
    }

    @Override
    public UserData getUserData() {
        return (RunnerUserData) mUserData;
    }

    public void jump() {
        if (!mIsJumping) {
            RunnerUserData r = (RunnerUserData) mBody.getUserData();
            mBody.applyLinearImpulse(r.getJumpingLinearImpulse(), mBody.getWorldCenter(), true);
            mIsJumping = true;
        }
    }

    public void landed() {
        mIsJumping = false;
    }

}
