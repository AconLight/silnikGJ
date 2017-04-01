package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;

public class Pasek extends Sprajt{
	SpriteObject pasek;
	public Pasek(float x, float y) {
		super(x, y);
		
		addSprite(pasek)
		.addTexture(Gdx.files.internal("data/frajerzy0.jpg"))
		.addTexture(Gdx.files.internal("data/frajerzy1.jpg"))
		.addTexture(Gdx.files.internal("data/frajerzy2.jpg"))
		.addTexture(Gdx.files.internal("data/frajerzy3.jpg"))
		.isVisible = true;
		pasek.frameNum = 0;
		
	}	
		
	
	void setTesto(){
		pasek.frameNum = 1;
	}
	
	void setNosacz(){
		pasek.frameNum = 2;
	}
	
	void setPoNosaczu(){
		pasek.frameNum = 3;
	}
}
