package photo.heller.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import photo.heller.game.box2d.UserData;
import photo.heller.game.enums.UserDataType;

public class BodyUtils {

    private static final String TAG = BodyUtils.class.getSimpleName();

    public static boolean bodyIsRunner(Body xBody) {
        UserData d = (UserData) xBody.getUserData();
        Gdx.app.log(TAG, "Is runner? " + (d.getUserDataType() == UserDataType.RUNNER));
        return d != null && d.getUserDataType() == UserDataType.RUNNER;
    }

    public static boolean bodyIsGround(Body xBody) {
        UserData d = (UserData) xBody.getUserData();
        Gdx.app.log(TAG, "Is ground? " + (d.getUserDataType() == UserDataType.GROUND));
        return d != null && d.getUserDataType() == UserDataType.GROUND;
    }
}
