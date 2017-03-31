package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;

public class Mebl extends PhysicObject{

	public Mebl(World world, float x, float y) {
		super(world, x, y);
		// TODO Auto-generated constructor stub
	}
	
	void set(int type) {
		switch(type){
		case MebleId.wiktor: {
			addSprite(new SpriteObject())
			.addTexture(Gdx.files.internal("data/badkogic.jpg"));
			break;
		}
		}
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		// TODO
	}

}
