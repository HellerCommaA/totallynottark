package photo.heller.game.box2d;

import com.badlogic.gdx.math.Vector2;
import photo.heller.game.enums.UserDataType;
import photo.heller.game.utils.Consts;

public class RunnerUserData extends UserData {

    private Vector2 mJumpingLinearImpulse;
    private final Vector2 mRunningPosition = new Vector2(Consts.RUNNER_X, Consts.RUNNER_Y);
    private final Vector2 mDodgePosition = new Vector2(Consts.RUNNER_DODGE_X, Consts.RUNNER_DODGE_Y);

    public RunnerUserData() {
        super();
        mJumpingLinearImpulse = Consts.RUNNER_JUMPING_LINEAR_IMPULSE;
        mUserData_t = UserDataType.RUNNER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return mJumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 xJumpingLinearImpulse) {
        mJumpingLinearImpulse = xJumpingLinearImpulse;
    }
    public float getDodgeAngle() {
        return (float) (-90f * (Math.PI / 180f));
    }
    public Vector2 getRunningPosition() {
        return mRunningPosition;
    }

    public Vector2 getDodgePosition() {
        return mDodgePosition;
    }
}
