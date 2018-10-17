package photo.heller.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import photo.heller.game.TotallyNotTarkov;
import photo.heller.game.utils.Utils;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Utils.WINDOW_HEIGHT;
		config.width = Utils.WINDOW_WIDTH;
		new LwjglApplication(new TotallyNotTarkov(), config);
	}
}
