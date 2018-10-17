package photo.heller.game.box2d;

import photo.heller.game.enums.UserDataType;

public abstract class UserData {
    protected UserDataType mUserData_t;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return mUserData_t;
    }

}
