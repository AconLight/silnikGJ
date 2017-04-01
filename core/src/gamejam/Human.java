package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Human extends PhysicObject{
	float time;
	float drenka;
	PhysicSpriteKulka hitbox;
	SpriteObject lewa, prawa, glowa;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	public Human(World world, float x, float y) {
		super(world, x, y);
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(50, 10, 1, 1);
		
		lewa = new SpriteObject(this, 0, 0);
		
		prawa = new SpriteObject(this, 0, 0);
		
		glowa = new SpriteObject(this, 0, 0);
		
		addSprite(lewa)
		.addTexture(Gdx.files.internal("data/lewa.png"));
		
		addSprite(prawa)
		.addTexture(Gdx.files.internal("data/prawa.png"));
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/kadlub1.png"));
		
		addSprite(glowa)
		.addTexture(Gdx.files.internal("data/glowa1.png"));
		
		speed = 5000;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		Gdx.app.log("asdasdasd", " " + hitbox.body.getLinearVelocity().x);
		/*if (hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + 
				hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y < Stats.maxSpeed*Stats.maxSpeed)
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		else {
			applyForce((float)(-Math.cos(Math.toRadians(alfa))*speed*delta), (float)(-Math.sin(Math.toRadians(alfa))*speed*delta));
		}*/
		

		speed = 1000;
		if((int)((time*13/20 + 17)/5)%2 == 1) isW = true;
		else isW = false;
		if((int)((time*21/20 + 6)/7)%2 == 1) isS = true;
		else isS = false;
		if((int)((time*4/20 + 27)/11)%2 == 1) isA = true;
		else isA = false;
		if((int)((time*23/20 + 13)/1)%2 == 1) isD = true;
		else isD = false;
		int i = 0;
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
			glowa.alfa = (float) (hitbox.alfa);
			
			//if (v > 30) v = 30;
			time += delta;
			drenka = (float) (Math.sin(time*5)*v/40);
			prawa.position.set(hitbox.position.x + drenka * (float)Math.cos((alfa)), hitbox.position.y + drenka * (float)Math.sin((alfa)));
			lewa.position.set(hitbox.position.x - drenka * (float)Math.cos((alfa)), hitbox.position.y - drenka * (float)Math.sin((alfa)));
			glowa.position.set(hitbox.position.x - drenka * (float)Math.cos((alfa)), hitbox.position.y - drenka * (float)Math.sin((alfa)));
	}
	
	public void move(float alfa) {
		this.alfa = alfa;		
	}

}