package gamejam;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Human extends PhysicObject{
	Random g;
	float tab[] = new float[12];
	float time;
	float drenka;
	PhysicSpriteKulka hitbox;
	SpriteObject lewa, prawa, glowa;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	public Human(World world, float x, float y) {
		super(world, x, y);
		g = new Random();
		for(int j = 0; j < 12; j++) {
			tab[j] = g.nextInt(10)+10;
		}
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(50, 10, 1, 1);
		
		lewa = new SpriteObject(this, 0, 0);
		
		prawa = new SpriteObject(this, 0, 0);
		
		glowa = new SpriteObject(this, 0, 0);
		
		addSprite(lewa)
		.addTexture(Gdx.files.internal("data/lewa" + (g.nextInt(3) + 2) + ".png"));
		
		addSprite(prawa)
		.addTexture(Gdx.files.internal("data/prawa" + (g.nextInt(3) + 2) + ".png"));
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/kadlub1.png"));
		
		addSprite(glowa)
		.addTexture(Gdx.files.internal("data/glowa" + (g.nextInt(3) + 1) + ".png"));
		
		speed = 500;
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
		

		if((int)((time*tab[0]/20 + tab[1])/tab[2])%2 == 1) isW = true;
		else isW = false;
		if((int)((time*tab[3]/20 + tab[4])/tab[5])%2 == 1) isS = true;
		else isS = false;
		if((int)((time*tab[6]/20 + tab[7])/tab[8])%2 == 1) isA = true;
		else isA = false;
		if((int)((time*tab[9]/20 + tab[10])/tab[11])%2 == 1) isD = true;
		else isD = false;
		int i = 0;
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed/2) {
			alfa = 90;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed/2) {
			alfa = 180;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed/2) {
			alfa = 270;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed/2) {
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
			glowa.position.set(hitbox.position);
			}
	
	public void move(float alfa) {
		this.alfa = alfa;		
	}

}