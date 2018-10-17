package photo.heller.game.box2d;

import com.badlogic.gdx.math.Vector2;
import photo.heller.game.enums.UserDataType;
import photo.heller.game.utils.Consts;

public class RunnerUserData extends UserData {

    private Vector2 mJumpingLinearImpulse;

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
}
