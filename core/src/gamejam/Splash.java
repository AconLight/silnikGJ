package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;

public class Splash extends Sprajt{

		public SpriteObject start;
		
	public Splash(float x, float y) {
		super(x, y);
		start = new SpriteObject(this, 0, 0);
		addSprite(start)
		.addTexture(Gdx.files.internal("data/red.png"))
		.addTexture(Gdx.files.internal("data/madewithjava.png"))
		.addTexture(Gdx.files.internal("data/prankarnia.png"))
		.addTexture(Gdx.files.internal("data/gameover.png"))
		.isVisible = true;
		start.frameNum = 0;
	}

}
