package gamejam;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Player extends PhysicObject{
	float time;
	float drenka;
	public PhysicSpriteKulka hitbox;
	public ArrayList<Proj> projs;
	public int projId;
	SpriteObject lewa, prawa;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	public boolean isDead;
	public Player(World world, float x, float y) {
		super(world, x, y);
		isDead = false;
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(50, 10, 1, 1);
		
		lewa = new SpriteObject(this, 0, 0);
		
		prawa = new SpriteObject(this, 0, 0);
		
		addSprite(lewa)
		.addTexture(Gdx.files.internal("data/lewa.png"));
		
		addSprite(prawa)
		.addTexture(Gdx.files.internal("data/prawa.png"));
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/kadlub.png"));
		
		projs = new ArrayList<Proj>();
		for(int i = 0; i < 16; i++) {
			projs.add(new Proj(world, this, 0, 0));
		}
		spriteObjects.addAll(projs);
		projId = 0;
		speed = 5000;
	}
	
	public void update(float delta, float vx, float vy) {
		if(!isDead) {
		super.update(delta, vx, vy);
		Gdx.app.log("asdasdasd", " " + hitbox.body.getLinearVelocity().x);
		/*if (hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + 
				hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y < Stats.maxSpeed*Stats.maxSpeed)
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		else {
			applyForce((float)(-Math.cos(Math.toRadians(alfa))*speed*delta), (float)(-Math.sin(Math.toRadians(alfa))*speed*delta));
		}*/
		

		speed = 4000;
			
		
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed) {
			alfa = 90;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed) {
			alfa = 180;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed) {
			alfa = 270;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed) {
			alfa = 0;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		
			sclVel(0.95f);
		
			float v = (float) (GameVars.box2dScale*Math.sqrt(hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y));
			if (v != 0) {
				if (hitbox.body.getLinearVelocity().x >= 0)
					hitbox.alfa = (float) Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v);
				else 
					hitbox.alfa = (float) (Math.PI - Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v));
			}
			else {
				hitbox.alfa = 0;			
			}
			alfa = hitbox.alfa;
			hitbox.alfa = (float) Math.toDegrees(hitbox.alfa);
			prawa.alfa = (float) (hitbox.alfa);
			lewa.alfa = (float) (hitbox.alfa);
			
			//if (v > 30) v = 30;
			time += delta;
			drenka = (float) (Math.sin(time*5)*v/40);
			prawa.position.set(hitbox.position.x + drenka * (float)Math.cos((alfa)), hitbox.position.y + drenka * (float)Math.sin((alfa)));
			lewa.position.set(hitbox.position.x - drenka * (float)Math.cos((alfa)), hitbox.position.y - drenka * (float)Math.sin((alfa)));
	
		
		}
	}
	public void move(float alfa) {
		this.alfa = alfa;		
	}
	public void throwProj() {
		projs.get(projId).position.set(hitbox.position);
		projs.get(projId).throwProj(alfa, hitbox.body.getLinearVelocity().x*GameVars.box2dScale, hitbox.body.getLinearVelocity().y*GameVars.box2dScale);
		projId++;
		if (projId > projs.size()-1) projId = 0;
	}

}
