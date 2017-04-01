package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;

public class Splash extends Sprajt{

		SpriteObject start;
		
	public Splash(float x, float y) {
		super(x, y);
		addSprite(start)
		.addTexture(Gdx.files.internal("data/red.jpg"))
		.addTexture(Gdx.files.internal("data/staff.jpg"))
		.isVisible = true;
		start.frameNum = 0;
	}

}
