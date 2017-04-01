package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.gameobjects.PhysicSpriteRect;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.SpriteObject;

public class Mebl extends PhysicObject{
	public PhysicSpriteObject hitbox,hitbox2;
	public Mebl(World world, float x, float y, int type) {
		super(world, x, y);
		set(type,x,y);
	}
	
	void set(int type,float x,float y) {
		switch(type){
		case MebleId.wiktor: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(155, 77, 1, 1, 1);
			addSprite(hitbox);
			//.addTexture(Gdx.files.internal("data/Wiktor1.1.png"));
			
			addSprite(new SpriteObject(this, 0, 20))
			.addTexture(Gdx.files.internal("data/testy/Wiktor1.1.png"));
			break;
		}
		case MebleId.stefan: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(155, 77, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, -5))
			.addTexture(Gdx.files.internal("data/testy/Stefan1.0.png"));
			break;
		}
		case MebleId.pufa: {
			hitbox = new PhysicSpriteKulka(world, this, x-20, y+15,BodyType.StaticBody);
			((PhysicSpriteKulka) hitbox).createBall(30, 1, 1, 1);
			hitbox2 = new PhysicSpriteKulka(world, this, x+25, y-18,BodyType.StaticBody);
			((PhysicSpriteKulka) hitbox2).createBall(25, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 0))
			.addTexture(Gdx.files.internal("data/testy/pufa1.0.png"));
			break;
		}

		}
	
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		// TODO
	}

}
