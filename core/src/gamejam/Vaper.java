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

public class Vaper extends PhysicObject{
	public int lives;
	public boolean isDead;
	Random g;
	float tab[] = new float[12];
	float time, time2, time3, t4;
	float drenka;
	public PhysicSpriteKulka hitbox;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	int fram;
	public boolean isVisible, isLeft;
	public boolean isTriggered = false;
	public Vaper(World world, float x, float y, float speed) {
		super(world, x, y);
		lives = 1;
		isVisible = false;
		time2 = 0;
		time3 = 0;
		t4 = 0;
		fram = 1;
		g = new Random();
		for(int j = 0; j < 12; j++) {
			tab[j] = g.nextInt(10)+10;
		}
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(40, 10, 1, 1);
		hitbox.scl = 0;
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/vape00.png"))
		.addTexture(Gdx.files.internal("data/vape01.png"))
		.addTexture(Gdx.files.internal("data/vape02.png"))
		.addTexture(Gdx.files.internal("data/vape03.png"))
		.addTexture(Gdx.files.internal("data/vape04.png"))
		.addTexture(Gdx.files.internal("data/vape05.png"))
		.addTexture(Gdx.files.internal("data/vape06.png"))
		.addTexture(Gdx.files.internal("data/vape07.png"))
		.addTexture(Gdx.files.internal("data/vape08.png"))
		.addTexture(Gdx.files.internal("data/vape09.png"))
		.addTexture(Gdx.files.internal("data/vape10.png"))
		.addTexture(Gdx.files.internal("data/vape11.png"))
		.addTexture(Gdx.files.internal("data/vape12.png"))
		.addTexture(Gdx.files.internal("data/vape13.png"))
		.frameTime = 999999f;
		hitbox.isPingPong = true;
		
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

		if (hitbox.frameNum == 13) {
		if((int)((5*time*tab[0]/20 + tab[1])/tab[2])%2 == 1) isW = true;
		else isW = false;
		if((int)((5*time*tab[3]/20 + tab[4])/tab[5])%2 == 1) isS = true;
		else isS = false;
		if((int)((5*time*tab[6]/20 + tab[7])/tab[8])%2 == 1) isA = true;
		else isA = false;
		if((int)((5*time*tab[9]/20 + tab[10])/tab[11])%2 == 1) isD = true;
		else isD = false;
		int i = 0;
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed/3) {
			alfa = 90;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*8*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*8*delta));
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed/3) {
			alfa = 180;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*8*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*8*delta));
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed/3) {
			alfa = 270;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*8*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*8*delta));
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed/3) {
			alfa = 0;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*8*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*8*delta));
		}
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
			
			
			//if (v > 30) v = 30;
			time += delta;
			drenka = (float) (Math.sin(time*5)*v/40);
			
			
			
			if (isVisible) {
				if(isDead) {
					hitbox.scl -= delta;
					if (hitbox.scl < 0) {
						hitbox.scl = 0;
						hitbox.body.setActive(false);
						isVisible = false;
					}
				}
				else {
					time2 += delta;
				if (hitbox.scl < 1) hitbox.scl += time2/10;
				else hitbox.scl = 1;
				}
				time3 += delta;
				
				
				
				if (time3 > 0.2f) {
					time3 -= 0.2f;
					hitbox.frameNum += fram;
				}
				if (hitbox.frameNum > 13) {
					fram = 0;
					t4 = 0;
					hitbox.frameNum = 13;
				}
				if (fram == 0) {
					t4 += delta;
					if (t4 > 8) {
						t4 = 0;
						if (hitbox.frameNum == 0) {
							fram = +1;
						}
						if (hitbox.frameNum == 13) {
							fram = -1;
						}
						else {
							fram = +1;
						}
						
					}
				}
				
				if (hitbox.frameNum < 0) {
					fram = 0;
					hitbox.frameNum = 0;
				}
				
			}
			
			
			
			}
	}
	public void setTarget(Vector2 playerPos, float scl) {
		if (hitbox.frameNum != 13) {
		float dx = playerPos.x - hitbox.position.x;
		float dy = playerPos.y - hitbox.position.y;
		float dr = (float) Math.sqrt(dx*dx + dy*dy);
		applyForce(GameVars.box2dScale*Stats.maxSpeed/2*scl*dx/dr, GameVars.box2dScale*Stats.maxSpeed/2*scl*dy/dr);
		}
	}
	public void setTarget(Vector2 playerPos) {
		if (hitbox.frameNum != 13) {
		float dx = playerPos.x - hitbox.position.x;
		float dy = playerPos.y - hitbox.position.y;
		float dr = (float) Math.sqrt(dx*dx + dy*dy);
		applyForce(GameVars.box2dScale*Stats.maxSpeed/10*dx/dr, GameVars.box2dScale*Stats.maxSpeed/10*dy/dr);
		}
	}
	public void render(SpriteBatch batch) {
		if(isVisible) super.render(batch);
	}

}
