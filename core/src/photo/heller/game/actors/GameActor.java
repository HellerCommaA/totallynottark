package photo.heller.game.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import photo.heller.game.box2d.UserData;

public abstract class GameActor extends Actor {

    protected Body mBody;
    protected Object mUserData;

    public GameActor(Body xBody) {
        if (xBody != null) {
            mBody = xBody;
            mUserData = xBody.getUserData();
        } else {
            System.err.println("GameActor::CTOR: GameActory body == null");
        }
    }

    public abstract UserData getUserData();

}
