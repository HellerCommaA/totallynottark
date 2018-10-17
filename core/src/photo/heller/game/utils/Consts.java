package photo.heller.game.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * This is a utility class meant to hold consts, for the most part
 */
public class Consts {
    public static final int WINDOW_WIDTH = 800; // overall game window width
    public static final int WINDOW_HEIGHT = 480; // overall game window height

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static float RUNNER_DENSITY = 0.5f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    public static final float RUNNER_GRAVITY_SCALE = 3f;


}
