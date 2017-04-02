package gamejam;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Pawian extends PhysicObject{
	Random g;
	float tab[] = new float[12];
	float time, time2;
	float drenka;
	public PhysicSpriteKulka hitbox;
	SpriteObject lewa, prawa, glowa;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	public int lives;
	public boolean isVisible, isDead;
	public boolean isTriggered = false;
	public Pawian(World world, float x, float y, float speed) {
		super(world, x, y);
		isVisible = false;
		g = new Random();
		for(int j = 0; j < 12; j++) {
			tab[j] = g.nextInt(10)+10;
		}
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(50, 10, 1, 1);
		hitbox.scl = 0;
		lewa = new SpriteObject(this, 0, 0);
		lewa.scl = 0;
		prawa = new SpriteObject(this, 0, 0);
		prawa.scl = 0;
		time2 = 0;
		lives = 50;
		addSprite(lewa)
		.addTexture(Gdx.files.internal("data/pawianlewa.png"));
		
		addSprite(prawa)
		.addTexture(Gdx.files.internal("data/pawianprawa.png"));
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/pawian.png"));
		
		
		this.speed = speed;
	}
	
	public void update(float delta, float vx, float vy) {
		if (isVisible) {
		super.update(delta, vx, vy);
		Gdx.app.log("asdasdasd", " " + hitbox.body.getLinearVelocity().x);
		/*if (hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + 
				hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y < Stats.maxSpeed*Stats.maxSpeed)
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		else {
			applyForce((float)(-Math.cos(Math.toRadians(alfa))*speed*delta), (float)(-Math.sin(Math.toRadians(alfa))*speed*delta));
		}*/
		if (isDead) {
			lewa.scl -= delta;
			prawa.scl -= delta;
			hitbox.scl -= delta;
			if (lewa.scl < 0) {
				isVisible = false;
				lewa.scl = 0;
				prawa.scl = 0;
				hitbox.scl = 0;
			}
		}
		if (time2 < 8) {
			time2 += delta;
		}
		if (time2 > 8) {
			time2 = -3;
		}
		if (time2 < 0) {
			isTriggered = true;
		}
		else {
			isTriggered = false;
		}
		
		
		if (lewa.scl < 1) {
			lewa.scl += delta/2;
			prawa.scl += delta/2;
			hitbox.scl += delta/2;
		}
		else {
			lewa.scl =1;
			prawa.scl =1;
			hitbox.scl =1;
		}

		if((int)((time*tab[0]/20 + tab[1])/tab[2])%2 == 1) isW = true;
		else isW = false;
		if((int)((time*tab[3]/20 + tab[4])/tab[5])%2 == 1) isS = true;
		else isS = false;
		if((int)((time*tab[6]/20 + tab[7])/tab[8])%2 == 1) isA = true;
		else isA = false;
		if((int)((time*tab[9]/20 + tab[10])/tab[11])%2 == 1) isD = true;
		else isD = false;
		int i = 0;
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed/3) {
			alfa = 90;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed/3) {
			alfa = 180;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed/3) {
			alfa = 270;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed/3) {
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
			//glowa.alfa = (float) (hitbox.alfa);
			
			//if (v > 30) v = 30;
			time += delta;
			drenka = (float) (Math.sin(time*5)*v/40);
			prawa.position.set(hitbox.position.x + drenka * (float)Math.cos((alfa)), hitbox.position.y + drenka * (float)Math.sin((alfa)));
			lewa.position.set(hitbox.position.x - drenka * (float)Math.cos((alfa)), hitbox.position.y - drenka * (float)Math.sin((alfa)));
			//glowa.position.set(hitbox.position);
			}
	}
	public void setTarget(Vector2 playerPos) {
		if (isTriggered) {
		float dx = playerPos.x - hitbox.position.x;
		float dy = playerPos.y - hitbox.position.y;
		float dr = (float) Math.sqrt(dx*dx + dy*dy);
		applyForce(GameVars.box2dScale*Stats.maxSpeed/10*dx/dr, GameVars.box2dScale*Stats.maxSpeed/10*dy/dr);
		}
	}
	public void setTarget(Vector2 playerPos, float scl) {
		float dx = playerPos.x - hitbox.position.x;
		float dy = playerPos.y - hitbox.position.y;
		float dr = (float) Math.sqrt(dx*dx + dy*dy);
		applyForce(GameVars.box2dScale*Stats.maxSpeed/2*scl*dx/dr, GameVars.box2dScale*Stats.maxSpeed/2*scl*dy/dr);
	}
	public void render(SpriteBatch batch) {
		if(isVisible) super.render(batch);
	}

}
