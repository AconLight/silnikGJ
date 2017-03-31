package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.SpriteObject;

public class Mebl extends PhysicObject{
	public PhysicSpriteObject hitbox;
	public Mebl(World world, float x, float y, int type) {
		super(world, x, y);
		set(type);
	}
	
	void set(int type) {
		switch(type){
		case MebleId.wiktor: {
			hitbox = new PhysicSpriteKulka(world, this, 0, 0);
			((PhysicSpriteKulka) hitbox).createBall(30, 1, 1, 1);
			addSprite(hitbox)
			.addTexture(Gdx.files.internal("data/badkogic.jpg"));
			break;
		}
		case MebleId.stefan: {
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
