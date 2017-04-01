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
	public SpriteObject sp, sp2;
	public int type;
	public Mebl(World world, float x, float y, int type) {
		super(world, x, y);
		set(type,x,y);
		this.type = type;
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
			hitbox = new PhysicSpriteKulka(world, this, x-20, y+15,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox).createBall(30, 100, 1, 1);
			hitbox2 = new PhysicSpriteKulka(world, this, x+25, y-18,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox2).createBall(25, 100, 1, 1);
			addDistanceJoint(hitbox.body, hitbox2.body);
			addSprite(hitbox);
			addSprite(hitbox2);
			sp = new SpriteObject(this, -20, 15);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/pufa_pol1.png"));
			sp2 = new SpriteObject(this, 25, -18);
			addSprite(sp2)
			.addTexture(Gdx.files.internal("data/testy/pufa_pol2.png"));
			break;
		}
		case MebleId.wojtas: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(75, 155, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 20))
			.addTexture(Gdx.files.internal("data/testy/wojtas1.png"));
			break;	
		}
		case MebleId.banany: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(50, 60, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 0))
			.addTexture(Gdx.files.internal("data/testy/banany.png"));
			break;	
		}
		case MebleId.pizza: {
			hitbox = new PhysicSpriteKulka(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteKulka) hitbox).createBall(100, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 0))
			.addTexture(Gdx.files.internal("data/testy/Pizza.png"));
			break;	
		}
		case MebleId.krzeslo: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(50, 45, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 0))
			.addTexture(Gdx.files.internal("data/testy/krzeslo.png"));
			break;	
		}
		}
	
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		switch(type){
		case MebleId.pufa: {
			sp.position.set(hitbox.position);
			sclVel(0.96f);
			sp2.position.set(hitbox2.position.x,hitbox2.position.y);
			break;
		}
		}
	}

}
