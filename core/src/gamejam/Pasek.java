package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;

public class Pasek extends Sprajt{
	SpriteObject pasek = new SpriteObject();

	public Pasek() {
		super(0, 0);
		
		addSprite(pasek)
		.addTexture(Gdx.files.internal("data/frajerzy0.png"))
		.addTexture(Gdx.files.internal("data/frajerzy1.png"))
		.addTexture(Gdx.files.internal("data/frajerzy2.png"))
		.addTexture(Gdx.files.internal("data/frajerzy3.png"))
		.isVisible = true;
		pasek.position.x = 960;
		pasek.position.y = 540;
		objectViewPriority = 2;
		pasek.frameNum = 0;
		pasek.frameTime = 99999;
		
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
