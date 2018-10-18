package photo.heller.game.actors;

import com.badlogic.gdx.physics.box2d.Body;
import photo.heller.game.box2d.RunnerUserData;
import photo.heller.game.box2d.UserData;

public class Runner extends GameActor {

    private boolean mIsJumping = false;
    private boolean mIsDodging = false;
    public Runner(Body xBody) {
        super(xBody);
    }

    @Override
    public UserData getUserData() {
        return (RunnerUserData) mUserData;
    }

    public void jump() {
        if (!mIsJumping || !mIsDodging) {
            RunnerUserData r = (RunnerUserData) mBody.getUserData();
            mBody.applyLinearImpulse(r.getJumpingLinearImpulse(), mBody.getWorldCenter(), true);
            mIsJumping = true;
        }
    }

    public void landed() {
        mIsJumping = false;
    }

    public void dodge() {
        if (!mIsJumping) {
            RunnerUserData r = (RunnerUserData) mBody.getUserData();
            mBody.setTransform(r.getDodgePosition(), r.getDodgeAngle());
            mIsDodging = true;
        }
    }

    public void stopDodge() {
        mIsDodging = false;
        RunnerUserData r = (RunnerUserData) mBody.getUserData();
        mBody.setTransform(r.getRunningPosition(), 0f);
    }

    public boolean isDodging() {
        return mIsDodging;
    }

}
