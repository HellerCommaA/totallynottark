package photo.heller.game.actors;

import com.badlogic.gdx.physics.box2d.Body;
import photo.heller.game.box2d.GroundUserData;
import photo.heller.game.box2d.UserData;

public class Ground extends GameActor {
    public Ground(Body xBody) {
        super(xBody);
    }

    @Override
    public UserData getUserData() {
        return (GroundUserData) mUserData;
    }
}
