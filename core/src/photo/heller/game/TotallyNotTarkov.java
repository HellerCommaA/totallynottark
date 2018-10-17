package photo.heller.game;

import com.badlogic.gdx.Game;
import photo.heller.game.screens.GameScreen;

public class TotallyNotTarkov extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
