package photo.heller.game.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import photo.heller.game.TotallyNotTarkov;
import photo.heller.game.utils.Consts;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Consts.WINDOW_HEIGHT;
		config.width = Consts.WINDOW_WIDTH;
		LwjglApplication app;
        new LwjglApplication(new TotallyNotTarkov(), config).setLogLevel(Application.LOG_DEBUG);

    }
}
