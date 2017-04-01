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
		set(type,x,y);
	}
	
	void set(int type,float x,float y) {
		switch(type){
		case MebleId.wiktor: {
			hitbox = new PhysicSpriteKulka(world, this, x, y);
			((PhysicSpriteKulka) hitbox).createBall(30, 1, 1, 1);
			addSprite(hitbox)
			.addTexture(Gdx.files.internal("data/Wiktor.png"));
			break;
		}
		case MebleId.pufa: {
			hitbox = new PhysicSpriteRect(world, this, 0, 0);
			((PhysicSpriteKulka) hitbox).createBall(30, 1, 1, 1);
			addSprite(new SpriteObject())
			.addTexture(Gdx.files.internal("data/pufa.png"));
			break;
		}
		}
	
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		// TODO
	}

}
