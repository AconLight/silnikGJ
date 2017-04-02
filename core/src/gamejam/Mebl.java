package gamejam;

import java.util.Random;

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
		case MebleId.sciana: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(2000, 25, 1, 1, 1);
			addSprite(hitbox);
			break;
		}
		case MebleId.sciana2: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(25, 1500, 1, 1, 1);
			addSprite(hitbox);
			break;
		}
		case MebleId.scianapoziom: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(200, 50, 1, 1, 1);
			addSprite(hitbox);
			addSprite(new SpriteObject(this, 0, 0))
			.addTexture(Gdx.files.internal("data/testy/sciana400x100.png"));
			break;
		}
		case MebleId.scianapion: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(50, 200, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/sciana400x100.png"));
			sp.alfa=90;
			break;
		}
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
			((PhysicSpriteKulka) hitbox).createBall(30, 50, 1, 1);
			hitbox2 = new PhysicSpriteKulka(world, this, x+25, y-18,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox2).createBall(25, 50, 1, 1);
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
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteRect) hitbox).createRect(45, 50, 80, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/krzeslo.png"));
			sp.alfa=180;
			break;
		}
		case MebleId.fotelkulka: {
			hitbox = new PhysicSpriteKulka(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox).createBall(60, 10, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/fotelkulka.png"));
			break;
		}
		case MebleId.krzeslo2: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteRect) hitbox).createRect(45, 50, 80, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/krzeslo2.png"));
	
			break;
		}
		case MebleId.kanapa: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(180, 86, 350, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/kanapa.png"));
			break;
			}
		case MebleId.pufajedzenie: {
			hitbox = new PhysicSpriteKulka(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox).createBall(75, 80, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/pufajedzenie.png"));
			break;
		}
		case MebleId.stolek: {
			hitbox = new PhysicSpriteKulka(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteKulka) hitbox).createBall(40, 60, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/stolek.png"));
			break;
		}
		case MebleId.szafka: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(50, 89, 500, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/szafka.png"));
			break;
		}
		case MebleId.pufa_mala: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteRect) hitbox).createRect(30, 30, 50, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/Pufa_Ma³a.png"));
			break;
		}
		case MebleId.kaloryfer: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(200, 30, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/kaloryfer.png"));
			break;
		}
		case MebleId.kaloryferpion: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(30, 200, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/kaloryfer.png"));
			sp.alfa=90;
			break;
		}

		case MebleId.tron: {
			hitbox = new PhysicSpriteRect(world, this, x-35, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(45, 80, 1, 1, 1);
			addSprite(hitbox);
			hitbox2 = new PhysicSpriteRect(world, this, x+45, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox2).createRect(35, 50, 1, 1, 1);
			addSprite(hitbox2);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/tron.png"));
			break;
		}
		case MebleId.fotel: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(60, 54, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/fotel.png"));
			break;
		}
		case MebleId.fotel2: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(60, 54, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/fotel.png"));
			sp.alfa=90;
			break;
		}
		case MebleId.filar: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(75, 75, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/filar.png"));
			break;
		}
		case MebleId.subway: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.DynamicBody);
			((PhysicSpriteRect) hitbox).createRect(20, 28, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/subway.png"));
			
			
			break;
		}
		case MebleId.stol: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(206, 100, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/czarnystol.png"));
			sp.alfa=90;
			break;
		}
		case MebleId.stol2: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(206, 100, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/czarnystol2.png"));
			sp.alfa=90;
			break;
		}
		case MebleId.stolpion: {
			hitbox = new PhysicSpriteRect(world, this, x, y,BodyType.StaticBody);
			((PhysicSpriteRect) hitbox).createRect(100, 206, 1, 1, 1);
			addSprite(hitbox);
			sp = new SpriteObject(this, 0, 0);
			addSprite(sp)
			.addTexture(Gdx.files.internal("data/testy/czarnystol2.png"));
			break;
		}
		}
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		switch(type){
		case MebleId.pufa: {
			sp.position.set(hitbox.position);
			sp.alfa=(float)(hitbox.body.getAngle()*180/Math.PI);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			sclVel(0.96f);
			sp2.position.set(hitbox2.position.x,hitbox2.position.y);
			sp2.alfa=(float)(hitbox2.body.getAngle()*180/Math.PI);
			hitbox2.body.setAngularVelocity(hitbox2.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.krzeslo: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.krzeslo2: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.pufajedzenie: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.fotelkulka: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.stolek: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.pufa_mala: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		case MebleId.subway: {
			sp.position.set(hitbox.position);
			sp.alfa=(float) (hitbox.body.getAngle()*180/Math.PI);
			sclVel(0.95f);
			hitbox.body.setAngularVelocity(hitbox.body.getAngularVelocity()*0.95f);
			break;
		}
		}
	}

}
