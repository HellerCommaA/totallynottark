package photo.heller.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import photo.heller.game.stages.GameStage;

public class GameScreen implements Screen {

    private GameStage mStage;

    public GameScreen() {
        mStage = new GameStage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float xDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mStage.draw();
        mStage.act(xDelta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
